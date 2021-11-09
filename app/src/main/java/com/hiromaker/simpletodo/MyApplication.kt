package com.hiromaker.simpletodo

import android.app.Application
import com.hiromaker.simpletodo.data.local.TaskDatabase

class MyApplication : Application() {

    companion object {
        lateinit var database: TaskDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = TaskDatabase.getInstance(applicationContext)
    }
}