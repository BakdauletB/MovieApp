package com.example.movie.presentation.character

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie.R
import com.example.movie.utils.base.BaseFragment
import com.example.movie.utils.base.viewBinding
import com.example.movie.presentation.character.adapter.NewsAdapter
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
    }
    private fun lets() {
        initRecyclerView()
        initViewModel()
        updateFeed()
        initObservers()
    }
    private fun initObservers() {
        vm.liveDataList.observe(viewLifecycleOwner,{
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







    //        setLoading(true)
//        viewModel.getLiveDataObserver().observe(viewLifecycleOwner, object : Observer<MovieResponse>{
//            override fun onChanged(t: MovieResponse?) {
//                if ( t != null){
//                    setLoading(false)
//                    newsAdapter?.addList(t.results)
//                    newsAdapter?.notifyDataSetChanged()
//                } else {
//                    Toast.makeText(requireContext(), "error in getting the date", Toast.LENGTH_SHORT).show()
//                }
//            }
//        })
//        viewModel.makeApicall()

}