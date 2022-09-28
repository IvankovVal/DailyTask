package com.example.dailytasks.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.dailytasks.model.TaskModel

@Dao //аннотация говорит,что это интерфейс нашей sql таблицы
interface TaskDao {
    @Insert//(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task:TaskModel)

    @Update
    suspend fun updateTask(task: TaskModel)

    @Delete
    suspend fun delete(task:TaskModel)

    @Query("SELECT * from task_table")
    fun getAllTasks():LiveData<List<TaskModel>>
}