package com.example.dailytasks.repository

import androidx.lifecycle.LiveData
import com.example.dailytasks.model.TaskModel

interface TaskRepository {
    val allTasks:LiveData<List<TaskModel>>//переменная(объект) содержащая весь список задач возвращаемый с помощью класса LiveData

    suspend fun isertTask(taskModel: TaskModel,onSuccess:()->Unit)//suspend fun будут работать с корутинами
    suspend fun deleteTask(taskModel: TaskModel,onSuccess: () -> Unit)
}