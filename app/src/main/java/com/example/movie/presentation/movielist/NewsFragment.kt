package com.example.movie.presentation.movielist

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie.App
import com.example.movie.R
import com.example.movie.presentation.base.BaseFragment
import com.example.movie.presentation.base.viewBinding
import com.example.movie.presentation.movielist.adapter.NewsAdapter
import com.example.movie.databinding.FragmentNewsBinding
import com.example.movie.presentation.activity.FoundationActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsFragment : BaseFragment(R.layout.fragment_news) {

    private var newsAdapter: NewsAdapter? = null
    private lateinit var vm: NewsViewModel
    private val binding by viewBinding(FragmentNewsBinding::bind)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lets()
        (requireActivity().application as App).appComponent.inject(NewsFragment())
    }
    private fun lets() {
        initRecyclerView()
        initViewModel()
        updateFeed()
        initObservers()
    }
    private fun initObservers() {
        vm.movieList.observe(viewLifecycleOwner,{
            setLoading(false)
            newsAdapter?.addList(it)
        })
    }
    private fun updateFeed() {
        CoroutineScope(Dispatchers.IO).launch {
            setLoading(true)
            vm.getNewsList()
        }
    }
    private fun initRecyclerView() {
        binding.rvNewsList.apply {
            newsAdapter = NewsAdapter {
                findNavController().navigate(R.id.action_fragmentNews_to_fragmentDetail,
                    Bundle().apply {
                        putInt("id", it)
                    })
            }
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(context)

        }
    }
    private fun initViewModel() {
        vm = (activity as FoundationActivity).viewModel

    }
    private fun setLoading(loading: Boolean) {
        binding.loadingViews.visibility = if (loading) View.VISIBLE else View.GONE

    }

}