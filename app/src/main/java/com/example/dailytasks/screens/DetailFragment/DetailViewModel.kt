package com.example.dailytasks.screens.DetailFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dailytasks.REPISITORY
import com.example.dailytasks.model.TaskModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel:ViewModel() {
    fun delete(taskModel: TaskModel,onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO){
            REPISITORY.deleteTask(taskModel){
                onSuccess
            }
        }
}