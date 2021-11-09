package com.hiromaker.simpletodo.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tag")
data class Tag(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @PrimaryKey val task_id: Int,
    @ColumnInfo(name = "name") val name: String
)