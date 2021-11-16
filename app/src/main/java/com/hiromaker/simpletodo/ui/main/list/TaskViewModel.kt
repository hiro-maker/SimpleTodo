package com.hiromaker.simpletodo.ui.main.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hiromaker.simpletodo.MyApplication
import com.hiromaker.simpletodo.data.local.entity.Task

class TaskViewModel : ViewModel() {
    fun getTaskList(term: Int): LiveData<List<Task>> {
        return MyApplication.database.taskDao().getTaskList(term)
    }
}