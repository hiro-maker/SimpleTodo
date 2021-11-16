package com.hiromaker.simpletodo.ui.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hiromaker.simpletodo.ui.main.list.TaskPageFragment
import com.hiromaker.simpletodo.util.Term

class TermPageAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = Term.values().size
    override fun createFragment(position: Int): Fragment {
        return TaskPageFragment(Term.values()[position])
    }
}