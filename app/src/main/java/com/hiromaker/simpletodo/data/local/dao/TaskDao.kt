package com.hiromaker.simpletodo.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hiromaker.simpletodo.data.local.entity.Task

@Dao
interface TaskDao {
    @Insert
    fun insert(data: Task)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateTask(movieEntities: List<Task>)

    @Query("SELECT * FROM Task")
    fun getTaskList(): LiveData<List<Task>>

    @Query("SELECT * FROM Task WHERE term=:term")
    fun getTaskList(term: Int): LiveData<List<Task>>

    @Query("SELECT * FROM Task WHERE id=:id")
    fun getTask(id: Int): LiveData<Task>

    @Query("SELECT MAX(id) FROM Task")
    fun getLastTaskId(): Int
}