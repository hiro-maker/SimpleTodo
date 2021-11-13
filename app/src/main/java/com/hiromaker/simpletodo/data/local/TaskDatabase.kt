package com.hiromaker.simpletodo.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hiromaker.simpletodo.data.local.dao.TaskDao
import com.hiromaker.simpletodo.data.local.entity.TASK_INIT_DATA
import com.hiromaker.simpletodo.data.local.entity.Task


@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object {

        private const val DB_NAME = "Task.db"

        private var INSTANCE: TaskDatabase? = null

        private val lock = Any()

        fun getInstance(context: Context): TaskDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        TaskDatabase::class.java, DB_NAME
                    )
                        .addCallback(object : RoomDatabase.Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                                db.execSQL(TASK_INIT_DATA)
                            }
                        })
                        .allowMainThreadQueries() // TODO 直す
                        .build()
                }
                return INSTANCE!!
            }
        }
    }
}