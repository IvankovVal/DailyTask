package com.example.dailytasks.screens.StartFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.dailytasks.APP
import com.example.dailytasks.R
import com.example.dailytasks.adapter.TaskAdapter
import com.example.dailytasks.databinding.FragmentStartBinding
import com.example.dailytasks.model.TaskModel


class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding
    lateinit var recyclerView:RecyclerView
    lateinit var adapter:TaskAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        viewModel.initDatabase()
        recyclerView = binding.rvTasks
        adapter = TaskAdapter()
        recyclerView.adapter = adapter
        viewModel.getAllTasks().observe(viewLifecycleOwner, { listTasks ->
            adapter.listTask.asReversed()
        })

        binding.btnAdd.setOnClickListener {
            APP.navController.navigate(R.id.action_startFragment_to_addTaskFragment)
        }
    }

    companion object{
    fun clickTask(taskModel: TaskModel){
        val bundel = Bundle()
        bundel.putSerializable("task",taskModel)
        APP.navController.navigate(R.id.action_startFragment_to_detailFragment,bundel)
    }}

    }
