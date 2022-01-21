package com.example.movie.content.list.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie.R
import kotlinx.android.synthetic.main.fragment_news.*
import com.example.movie.common.views.BaseFragment
import com.example.movie.common.views.viewBinding
import com.example.movie.content.list.view.adapter.NewsAdapter
import com.example.movie.content.list.viewmodel.MovieNewsViewModel
import com.example.movie.databinding.FragmentNewsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsFragment : BaseFragment(R.layout.fragment_news) {

    private val newsAdapter: NewsAdapter =
        NewsAdapter(this)
    private lateinit var viewModel: MovieNewsViewModel
    private val binding by viewBinding(FragmentNewsBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lets()
    }

    private fun lets() {
        initViewModel()
        initRecyclerView()
        updateFeed()
        initListeners()
        initObservers()
    }

    private fun initListeners() {
        binding.rvNewsList.setOnClickListener {
            navigateTo(R.id.detailFragment)
        }
    }

    private fun initObservers() {
        viewModel.newsList.observe(viewLifecycleOwner,{
            setLoading(false)
            newsAdapter.addList(it)
        })
    }
    fun navigate(id: Int) {
        findNavController().navigate(R.id.action_fragmentNews_to_fragmentDetail,Bundle().apply {
            putInt("id", id)
        })
    }


    private fun updateFeed() {
        CoroutineScope(Dispatchers.IO).launch {
            setLoading(true)
            viewModel.getNewsList()
        }
    }

    private fun initRecyclerView() {
        binding.rvNewsList.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(context)
        }

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[MovieNewsViewModel::class.java]
    }
    private fun setLoading(loading: Boolean) {
        loadingViews.visibility = if (loading) View.VISIBLE else View.GONE

    }


}