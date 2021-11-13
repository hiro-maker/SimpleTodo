package com.hiromaker.simpletodo.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hiromaker.simpletodo.ui.main.task.TaskPageFragment

class TermPageAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3
    override fun createFragment(position: Int): Fragment {
        // Return a NEW fragment instance in createFragment(int)
        val fragment = TaskPageFragment()
        fragment.arguments = Bundle().apply {
            // Our object is just an integer :-P
            putInt(TaskPageFragment.ARG_OBJECT, position + 1)
        }
        return fragment
    }

}