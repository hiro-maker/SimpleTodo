package com.hiromaker.simpletodo.ui.main.list

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hiromaker.simpletodo.R

class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val icon: TextView = itemView.findViewById(R.id.task_icon)
    val taskName: TextView = itemView.findViewById(R.id.task_name)
    val successCheckBox: CheckBox = itemView.findViewById(R.id.success_check_box)
}