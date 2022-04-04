package com.hiromaker.simpletodo.ui.main.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hiromaker.simpletodo.MyApplication
import com.hiromaker.simpletodo.data.local.entity.Task

import java.util.concurrent.Executors


class TaskViewModel : ViewModel() {

    private val taskDao = MyApplication.database.taskDao()
    private val executorService = Executors.newSingleThreadExecutor()

    fun getTaskList(term: Int): LiveData<List<Task>> {
        return taskDao.getTaskList(term)
    }

    fun updateTaskList(taskEntities: List<Task>) {
        taskDao.updateTaskList(taskEntities)
    }

    fun moveTask(fromTask: Task, toTask: Task) {
        executorService.execute { taskDao.moveTask(fromTask, toTask) }
    }

    fun deleteTask(task: Task) {
        taskDao.deleteTask(task)
//        executorService.execute { taskDao.deleteTask(task) }
    }
}