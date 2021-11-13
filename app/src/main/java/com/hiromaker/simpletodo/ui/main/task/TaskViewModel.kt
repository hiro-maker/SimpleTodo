package com.hiromaker.simpletodo.ui.main.task

import androidx.lifecycle.ViewModel
import com.hiromaker.simpletodo.MyApplication

class TaskViewModel : ViewModel() {
    val mTaskList = MyApplication.database.taskDao().getTaskListNow()
}