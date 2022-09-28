package com.example.dailytasks.repository

import androidx.lifecycle.LiveData
import com.example.dailytasks.dao.TaskDao
import com.example.dailytasks.model.TaskModel

class TaskRealization(private val taskDao: TaskDao):TaskRepository {
    override val allTasks: LiveData<List<TaskModel>>
        get() = taskDao.getAllTasks()

    override suspend fun isertTask(taskModel: TaskModel, onSuccess: () -> Unit) {
        taskDao.insert(taskModel)
        onSuccess()
    }

    override suspend fun deleteTask(taskModel: TaskModel, onSuccess: () -> Unit) {
        taskDao.delete(taskModel)
        onSuccess()
    }
}