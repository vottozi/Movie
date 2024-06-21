package com.example.movie.ui.tvShowDetails.episodes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.movie.R
import com.example.movie.databinding.FragmentEpisodesBinding
import com.example.movie.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodesFragment : BaseFragment<FragmentEpisodesBinding>() {

    override val layoutIdFragment = R.layout.fragment_episodes
    override val viewModel: EpisodesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.episodes))
        setEpisodesAdapter()
    }

    private fun setEpisodesAdapter() {
        binding.recyclerView.adapter = EpisodeAdapter(mutableListOf(), viewModel)
    }
}
