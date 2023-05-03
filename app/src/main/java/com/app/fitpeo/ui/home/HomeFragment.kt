package com.app.fitpeo.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.viewModels

import com.app.fitpeo.adapter.PhotosAdapter
import com.app.fitpeo.base.BaseFragment

import com.app.fitpeo.databinding.FragmentHomeBinding

import com.app.fitpeo.model.ModelPhoto

import com.app.fitpeo.utils.Utility.showToast
import com.app.fitpeo.viewmodel.HomeViewModel
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private var binding: FragmentHomeBinding? = null
    
    private val viewModel: HomeViewModel by viewModels()
    var dialog:AlertDialog?=null

    var modelDashboard=ArrayList<ModelPhoto>()
    lateinit var adapter:PhotosAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        if (binding==null)
        {
            binding = FragmentHomeBinding.inflate(inflater, container, false)
            init()
        }
        return binding!!.root
    }

    fun init()
    {
        adapter=PhotosAdapter(requireContext(),modelDashboard)
        binding?.recyclerView?.adapter=adapter

        binding!!.swiprefresh.setOnRefreshListener {
            binding!!.swiprefresh.isRefreshing=false
            callAPI()
        }

        observeData()
        callAPI()

    }

    fun callAPI()
    {
       viewModel.callAPI()
    }

    fun observeData() {
        viewModel.userResponse.observe(requireActivity()) {
            Log.d("TAG", "observeData: " + Gson().toJson(it))
            if(it.size>0)
            {
                modelDashboard.clear()
                modelDashboard.addAll(it)
                adapter.notifyDataSetChanged()

            }
            else
            {
                showToast("Contact to support",2)
            }

        }

        viewModel.error.observe(requireActivity()) {
            showToast(it,2)
        }

        viewModel.loading.observe(requireActivity()) {
            loadingProgress(it)
        }

    }



}