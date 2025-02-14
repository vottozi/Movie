package com.example.movie.ui.allMedia

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.PagingData
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movie.R
import com.example.movie.databinding.FragmentAllMovieBinding
import com.example.movie.domain.enums.AllMediaType
import com.example.movie.ui.adapters.LoadUIStateAdapter
import com.example.movie.ui.base.BaseFragment
import com.example.movie.ui.models.MediaUiState
import com.example.movie.utilities.collect
import com.example.movie.utilities.collectLast
import com.example.movie.utilities.setSpanSize
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllMovieFragment : BaseFragment<FragmentAllMovieBinding>() {
    override val layoutIdFragment = R.layout.fragment_all_movie
    override val viewModel: AllMovieViewModel by viewModels()
    private val allMediaAdapter: AllMediaAdapter by lazy { AllMediaAdapter(viewModel) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getTitle(viewModel.args.type))
        setMovieAdapter()
        collectEvent()
    }

    private fun setMovieAdapter() {
        val footerAdapter = LoadUIStateAdapter(allMediaAdapter::retry)
        binding.recyclerMedia.adapter = allMediaAdapter.withLoadStateFooter(footerAdapter)

        val mManager = binding.recyclerMedia.layoutManager as GridLayoutManager
        mManager.setSpanSize(footerAdapter, allMediaAdapter, mManager.spanCount)

        collect(flow = allMediaAdapter.loadStateFlow,
            action = {
                viewModel.setErrorUiState(it)
            })

        collectLast(viewModel.uiState.value.allMedia, ::setAllMedia)
    }


    private suspend fun setAllMedia(itemsPagingData: PagingData<MediaUiState>) {
        allMediaAdapter.submitData(itemsPagingData)
    }

    private fun collectEvent() {
        collectLast(viewModel.mediaUIEvent) {
            it?.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: MediaUIEvent) {
        when (event) {
            MediaUIEvent.BackEvent -> {
                removeFragment()
            }
            is MediaUIEvent.ClickMovieEvent -> {
                findNavController().navigate(
                    AllMovieFragmentDirections.actionAllMovieFragmentToMovieDetailFragment(
                        event.movieID
                    )
                )
            }
            is MediaUIEvent.ClickSeriesEvent -> {
                findNavController().navigate(
                    AllMovieFragmentDirections.actionAllMovieFragmentToTvShowDetailsFragment(
                        event.seriesID
                    )
                )
            }
            MediaUIEvent.RetryEvent -> {
                allMediaAdapter.retry()
            }
        }
    }

    private fun removeFragment() {
        findNavController().popBackStack()
    }

    private fun getTitle(type: AllMediaType): String {
        return when (type) {
            AllMediaType.ON_THE_AIR -> resources.getString(R.string.title_on_air)
            AllMediaType.AIRING_TODAY -> resources.getString(R.string.title_airing_today)
            AllMediaType.LATEST -> resources.getString(R.string.latest)
            AllMediaType.POPULAR -> resources.getString(R.string.popular)
            AllMediaType.TOP_RATED -> resources.getString(R.string.title_top_rated_tv_show)
            AllMediaType.TRENDING -> resources.getString(R.string.title_trending)
            AllMediaType.NOW_STREAMING -> resources.getString(R.string.title_streaming)
            AllMediaType.UPCOMING -> resources.getString(R.string.title_upcoming)
            AllMediaType.MYSTERY -> resources.getString(R.string.title_mystery)
            AllMediaType.ADVENTURE -> resources.getString(R.string.title_adventure)
            AllMediaType.ACTOR_MOVIES -> ""
        }
    }

}