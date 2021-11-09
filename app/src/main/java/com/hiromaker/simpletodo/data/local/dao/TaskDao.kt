package com.hiromaker.simpletodo.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hiromaker.simpletodo.data.local.entity.Task

@Dao
interface TaskDao {
    @Query("SELECT * FROM Task")
    fun getTaskList(): LiveData<List<Task>>

    @Query("SELECT * FROM Task")
    fun getTaskListNow(): List<Task>

    @Insert
    fun insert(data: Task)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovies(movieEntities: List<Task>)

    @Query("SELECT * FROM Task WHERE id=:id")
    fun getTask(id: Int): LiveData<Task>
}