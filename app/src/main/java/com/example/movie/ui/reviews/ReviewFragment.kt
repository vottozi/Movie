package com.example.movie.ui.reviews

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.movie.R
import com.example.movie.databinding.FragmentReviewBinding
import com.example.movie.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReviewFragment : BaseFragment<FragmentReviewBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_review
    override val viewModel: ReviewViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.review))
        binding.commentReviewAdapter.adapter = ReviewAdapter(emptyList(), viewModel)
    }

}