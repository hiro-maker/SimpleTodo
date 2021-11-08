package com.hiromaker.simpletodo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.hiromaker.simpletodo.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState:
        Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO: Use the ViewModel
        // https://qiita.com/kasa_le/items/b0ca862e89790d3e6e80

        // SampleViewModel定義
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // ViewModelカウンターイベントをリッスン.
        view.findViewById<AppCompatButton>(R.id.countUpButton).apply {
            setOnClickListener {
                viewModel.onClickCountUp()
            }
        }

        // カウント時のイベント1
        val viewModelValueView = view.findViewById<AppCompatTextView>(R.id.viewModelValueView)
        viewModel.count.observe(viewLifecycleOwner, { count ->
            viewModelValueView.text = count.toString()
        })
        // カウント時のイベント2
        val countMessageView = view.findViewById<AppCompatTextView>(R.id.countMessageView)
        viewModel.countMessage.observe(viewLifecycleOwner, { countMessage ->
            countMessageView.text = countMessage
        })

        //Header
        viewPager = view.findViewById(R.id.pager)
        viewPager.adapter = TaskPageAdapter(this)
        //List
        //date
        //Footer
    }
}