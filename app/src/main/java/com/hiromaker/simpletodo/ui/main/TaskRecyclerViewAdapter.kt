package com.hiromaker.simpletodo.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hiromaker.simpletodo.R
import com.hiromaker.simpletodo.data.model.Task


class TaskRecyclerViewAdapter(private val taskList: ArrayList<Task>) :
    RecyclerView.Adapter<TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.task_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = taskList[position]
        holder.icon.text = task.icon
        holder.taskName.text = task.title
        holder.successCheckBox.isChecked = task.isSuccess
    }

    override fun getItemCount() = taskList.size
}