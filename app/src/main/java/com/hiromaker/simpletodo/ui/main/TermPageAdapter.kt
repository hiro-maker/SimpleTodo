package com.hiromaker.simpletodo.ui.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hiromaker.simpletodo.ui.main.task.TaskPageFragment

class TermPageAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3
    override fun createFragment(position: Int): Fragment {
        return TaskPageFragment(position)
    }
}