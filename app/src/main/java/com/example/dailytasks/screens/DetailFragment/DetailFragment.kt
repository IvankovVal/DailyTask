package com.example.dailytasks.screens.DetailFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.dailytasks.APP
import com.example.dailytasks.R
import com.example.dailytasks.databinding.FragmentDetailBinding
import com.example.dailytasks.model.TaskModel


class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    lateinit var currentTask:TaskModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater,container,false)
        currentTask = arguments?.getSerializable("task") as TaskModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding.tvTitleDetail.text = currentTask.title
        binding.tvDescDetail.text = currentTask.description

        binding.btnDelete.setOnClickListener {
            viewModel.delete(currentTask){}
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }


        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }

    }
}