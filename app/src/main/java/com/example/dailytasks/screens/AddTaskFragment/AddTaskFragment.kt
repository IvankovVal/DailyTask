package com.example.dailytasks.screens.AddTaskFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dailytasks.APP
import com.example.dailytasks.R
import com.example.dailytasks.databinding.FragmentAddTaskBinding
import com.example.dailytasks.model.TaskModel


class AddTaskFragment : Fragment() {

lateinit var binding: FragmentAddTaskBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddTaskBinding.inflate(layoutInflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(AddTaskViewModel::class.java)
        binding.btnAddNewTask.setOnClickListener {
            val title = binding.etAddTitle.text.toString()
            val description = binding.etAddDesc.text.toString()
            viewModel.insert(TaskModel(title = title, description = description)){}
            APP.navController.navigate(R.id.action_addTaskFragment_to_startFragment)
        }

        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_addTaskFragment_to_startFragment)
        }
    }
}