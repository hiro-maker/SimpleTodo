package com.hiromaker.simpletodo.ui.main.add

import android.text.TextUtils
import androidx.lifecycle.ViewModel
import com.hiromaker.simpletodo.MyApplication
import com.hiromaker.simpletodo.data.local.entity.Task

class AddTaskViewModel : ViewModel() {

    private val taskDao = MyApplication.database.taskDao()

    fun addTask(task: Task) {
        if (TextUtils.isEmpty(task.icon)) {
            val lastId = taskDao.getLastTaskId()
            task.icon = toAlphabetic(lastId) + "."
        }
        taskDao.insert(task)
    }

    private fun toAlphabetic(i: Int): String {
        if (i < 0) {
            return "-" + toAlphabetic(-i - 1)
        }
        val quot = i / 26
        val rem = i % 26
        val letter = ('a'.code + rem).toChar()
        return if (quot == 0) {
            "" + letter
        } else {
            toAlphabetic(quot - 1) + letter
        }
    }
}