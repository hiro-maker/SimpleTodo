package com.hiromaker.simpletodo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.hiromaker.simpletodo.R
import com.hiromaker.simpletodo.ui.main.add.AddTaskDialogFragment
import com.hiromaker.simpletodo.util.Term

class MainFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO: Use the ViewModel
        // https://qiita.com/kasa_le/items/b0ca862e89790d3e6e80

        //Header, TaskList
        val viewPager = view.findViewById<ViewPager2>(R.id.pager).apply {
            adapter = TermPageAdapter(this@MainFragment)
            isUserInputEnabled = false
        }
        val term = view.findViewById<TabLayout>(R.id.term_tab)
        TabLayoutMediator(term, viewPager) { tab, position ->
            tab.text = Term.values()[position].name
        }.attach()

        // Date

        // Footer
        view.findViewById<FloatingActionButton>(R.id.add_fab).apply {
            setOnClickListener {
                AddTaskDialogFragment().show(parentFragmentManager, AddTaskDialogFragment.TAG)
            }
        }
    }
}