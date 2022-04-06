package com.hiromaker.simpletodo.ui.main.add

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputEditText
import com.hiromaker.simpletodo.MainActivity
import com.hiromaker.simpletodo.R
import com.hiromaker.simpletodo.data.local.entity.Task


class AddTaskDialogFragment : BottomSheetDialogFragment() {

    private val viewModel by viewModels<AddTaskViewModel>()

    companion object {
        const val TAG = "AddTaskDialogFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.AddTaskDialogStyle)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        BottomSheetDialog(requireContext(), theme).apply {
            setContentView(R.layout.input_task_sheet)
        }.let {
            settingKeyboard(it)
            // Push SEND.
            it.findViewById<Button>(R.id.task_add_send)?.apply {
                setOnClickListener {
                    addTask()
                }
            }
            return it
        }
    }

    private fun settingKeyboard(dialog: BottomSheetDialog) {
        dialog.apply {
            setOnShowListener {
                activity?.let { it1 ->
                    Handler(it1.mainLooper).post {
                        findViewById<FrameLayout>(R.id.design_bottom_sheet)?.let {
                            BottomSheetBehavior.from(it).apply {
                                state = BottomSheetBehavior.STATE_EXPANDED
                            }
                        }
                    }
                }
            }
            findViewById<TextInputEditText>(R.id.text_field)?.also { it ->
                it.postDelayed({
                    if (it.requestFocus()) {
                        (activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).apply {
                            showSoftInput(it, InputMethodManager.SHOW_IMPLICIT)
                        }
                    }
                }, 100)
                it.setOnEditorActionListener { _, actionId, event ->
                    if (actionId == EditorInfo.IME_ACTION_DONE
                        || event.action == KeyEvent.ACTION_DOWN
                        && event.keyCode == KeyEvent.KEYCODE_ENTER
                    ) {
                        addTask()
                        return@setOnEditorActionListener true
                    }
                    return@setOnEditorActionListener false
                }

            }
        }
    }

    private fun addTask() {
        dialog?.findViewById<TextInputEditText>(R.id.text_field)?.let { titleView ->
            val title = titleView.text.toString()
            if (TextUtils.isEmpty(title)) {
                dialog?.dismiss()
                return
            }
            (activity as? MainActivity)?.getTermPosition()?.let { term ->
                val task = Task(
                    icon = "",
                    title = title,
                    description = null,
                    startTime = null,
                    endTime = null,
                    isRemind = false,
                    term = term,
                    priority = 0,
                    isSuccess = false
                )
                viewModel.addTask(task)
                dialog?.dismiss()
            }
        }
    }
}