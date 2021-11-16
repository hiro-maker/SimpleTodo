package com.hiromaker.simpletodo.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * 一つのタスクのデータモデル.
 */
@Entity(tableName = "task")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "icon") var icon: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "start_time") val startTime: String?,
    @ColumnInfo(name = "end_time") val endTime: String?,
    @ColumnInfo(name = "is_remind") val isRemind: Boolean,
    @ColumnInfo(name = "term") val term: Int,
    @ColumnInfo(name = "priority") val priority: Int,
    @ColumnInfo(name = "is_success") val isSuccess: Boolean
)

const val TASK_INIT_DATA = "INSERT INTO 'task' VALUES " +
        "(NULL, 'a.', 'title01', NULL, NULL, NULL, false, 0, 0, false)," +
        "(NULL, 'b.', 'title02', NULL, NULL, NULL, false, 0, 0, true)," +
        "(NULL, 'c.', 'title03', NULL, NULL, NULL, false, 0, 0, false)," +
        "(NULL, 'd.', 'title04', NULL, NULL, NULL, false, 0, 0, true)," +
        "(NULL, 'a.', 'title11', NULL, NULL, NULL, false, 1, 0, true)," +
        "(NULL, 'b.', 'title12', NULL, NULL, NULL, false, 1, 0, true)," +
        "(NULL, 'c.', 'title13', NULL, NULL, NULL, false, 1, 0, false)," +
        "(NULL, 'd.', 'title14', NULL, NULL, NULL, false, 1, 0, false)," +
        "(NULL, 'a.', 'title21', NULL, NULL, NULL, false, 2, 0, false)," +
        "(NULL, 'b.', 'title22', NULL, NULL, NULL, false, 2, 0, false)," +
        "(NULL, 'c.', 'title23', NULL, NULL, NULL, false, 2, 0, true)," +
        "(NULL, 'd.', 'title24', NULL, NULL, NULL, false, 2, 0, true)"