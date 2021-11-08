package com.hiromaker.simpletodo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hiromaker.simpletodo.R
import com.hiromaker.simpletodo.data.model.Task

class TaskPageFragment : Fragment() {

    companion object {
        const val ARG_OBJECT = "object"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.task_page_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val taskListData = arrayListOf<Task>()

        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            taskListData.add(Task(getInt(ARG_OBJECT).toString(), "title0", "", "", "", false, 0, 0, false, emptyArray()))
        }

        taskListData.add(Task("a.", "title1", "", "", "", false, 0, 0, false, emptyArray()))
        taskListData.add(Task("b.", "title2", "", "", "", false, 0, 0, true, emptyArray()))
        taskListData.add(Task("c.", "title3", "", "", "", false, 0, 0, false, emptyArray()))
        taskListData.add(Task("d.", "title4", "", "", "", false, 0, 0, true, emptyArray()))

        val taskListView = view.findViewById<RecyclerView>(R.id.task_list)
        taskListView.layoutManager = LinearLayoutManager(context)
        taskListView.adapter = TaskRecyclerViewAdapter(taskListData)
    }
}