package com.example.dailytasks.screens.StartFragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.dailytasks.REPISITORY
import com.example.dailytasks.db.TaskDatabase
import com.example.dailytasks.model.TaskModel
import com.example.dailytasks.repository.TaskRealization

class StartViewModel(application: Application):AndroidViewModel(application) {

    var context = application

    fun initDatabase(){
        val daoTask = TaskDatabase.getInstance(context).getTaskDao()
        REPISITORY = TaskRealization(daoTask)
    }
    fun getAllTasks():LiveData<List<TaskModel>>{
        return REPISITORY.allTasks
    }
}