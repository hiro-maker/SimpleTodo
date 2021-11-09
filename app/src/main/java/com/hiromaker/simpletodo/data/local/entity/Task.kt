package com.hiromaker.simpletodo.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * 一つのタスクのデータモデル.
 */
@Entity(tableName = "task")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "icon") val icon: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "start_time") val startTime: String?,
    @ColumnInfo(name = "end_time") val endTime: String?,
    @ColumnInfo(name = "is_remind") val isRemind: Boolean,
    @ColumnInfo(name = "term") val term: Int,
    @ColumnInfo(name = "priority") val priority: Int,
    @ColumnInfo(name = "is_success") val isSuccess: Boolean
)