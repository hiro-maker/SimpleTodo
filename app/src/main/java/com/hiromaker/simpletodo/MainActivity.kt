package com.hiromaker.simpletodo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.hiromaker.simpletodo.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment())
                .commitNow()
        }
    }

    fun getTermPosition(): Int? {
        return findViewById<TabLayout>(R.id.term_tab)?.selectedTabPosition
    }
}