package com.hiromaker.simpletodo.ui.main.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hiromaker.simpletodo.data.local.entity.Task
import com.hiromaker.simpletodo.databinding.TaskRowBinding


class TaskRecyclerViewAdapter(private val taskList: MutableList<Task>) : RecyclerView.Adapter<TaskRecyclerViewAdapter.TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(TaskRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = taskList[position]
        holder.binding.apply {
            taskIcon.text = task.icon
            taskName.text = task.title
            successCheckBox.isChecked = task.isSuccess
        }
    }

    override fun getItemCount() = taskList.size

    fun getItem(position: Int): Task? {
        return taskList.getOrNull(position)
    }

    fun getItemList(): List<Task> {
        return taskList
    }

    fun deleteItem(index: Int) {
        taskList.removeAt(index)
    }

    inner class TaskViewHolder(val binding: TaskRowBinding) : RecyclerView.ViewHolder(binding.root)
}