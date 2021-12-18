package com.hiromaker.simpletodo.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hiromaker.simpletodo.data.local.entity.Task

@Dao
interface TaskDao {
    @Insert
    fun insert(data: Task)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateTaskList(taskEntities: List<Task>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Query("SELECT * FROM Task WHERE term=:term")
    fun getTaskList(term: Int): LiveData<List<Task>>

    @Query("SELECT * FROM Task WHERE id=:id")
    fun getTask(id: Int): LiveData<Task>

    @Query("SELECT MAX(id) FROM Task")
    fun getLastTaskId(): Int

    @Transaction
    fun moveTask(fromTask: Task, toTask: Task) {
        val fromTaskId = fromTask.id
        val toTaskId = toTask.id
        fromTask.id = toTaskId
        toTask.id = fromTaskId
        updateTask(fromTask)
        updateTask(toTask)
    }
}