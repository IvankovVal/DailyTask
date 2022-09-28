package com.example.dailytasks.screens.AddTaskFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import com.example.dailytasks.REPISITORY
import com.example.dailytasks.model.TaskModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddTaskViewModel:ViewModel() {
    fun insert(taskModel: TaskModel, onSuccess:() -> Unit) =
        viewModelScope.launch  (Dispatchers.IO){
            REPISITORY.isertTask(taskModel){
                onSuccess
            }
        }
}