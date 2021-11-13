package com.hiromaker.simpletodo.ui.main.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hiromaker.simpletodo.R
import com.hiromaker.simpletodo.data.local.entity.Task

class TaskPageFragment : Fragment() {

    companion object {
        const val ARG_OBJECT = "object"
    }

    private lateinit var viewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[TaskViewModel::class.java]
        return inflater.inflate(R.layout.task_page_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val taskListData = mutableListOf<Task>()
        taskListData.addAll(viewModel.mTaskList)

        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            taskListData.add(
                Task(
                    0,
                    getInt(ARG_OBJECT).toString(),
                    "title0",
                    "",
                    "",
                    "",
                    false,
                    0,
                    0,
                    false
                )
            )
        }
        val taskListView = view.findViewById<RecyclerView>(R.id.task_list)
        taskListView.layoutManager = LinearLayoutManager(context)
        taskListView.adapter = TaskRecyclerViewAdapter(taskListData)
    }
}