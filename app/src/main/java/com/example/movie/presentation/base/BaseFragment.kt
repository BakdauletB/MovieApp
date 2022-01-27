package com.example.movie.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.movie.R

open class BaseFragment(private val resource: Int) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(resource, container, false)
    }

    fun navigateTo(navDirections: Int) {
        requireActivity().findNavController(R.id.container)
            .navigate(navDirections)
    }

}