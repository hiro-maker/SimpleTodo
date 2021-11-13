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

class TaskPageFragment : Fragment() {

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
        viewModel.mTaskList.observe(viewLifecycleOwner, {
            val taskListView = view.findViewById<RecyclerView>(R.id.task_list)
            taskListView.layoutManager = LinearLayoutManager(context)
            taskListView.adapter = TaskRecyclerViewAdapter(it)
        })
    }
}