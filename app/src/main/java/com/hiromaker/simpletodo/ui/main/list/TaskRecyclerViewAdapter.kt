package com.hiromaker.simpletodo.ui.main.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hiromaker.simpletodo.R
import com.hiromaker.simpletodo.data.local.entity.Task


class TaskRecyclerViewAdapter(private val taskList: List<Task>) :
    RecyclerView.Adapter<TaskRecyclerViewAdapter.TaskViewHolder>() {
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

    fun getItem(position: Int): Task {
        return taskList[position]
    }

    fun getItemList(): List<Task> {
        return taskList
    }

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: TextView = itemView.findViewById(R.id.task_icon)
        val taskName: TextView = itemView.findViewById(R.id.task_name)
        val successCheckBox: CheckBox = itemView.findViewById(R.id.success_check_box)
    }
}