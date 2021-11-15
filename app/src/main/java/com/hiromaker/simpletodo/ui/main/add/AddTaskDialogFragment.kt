package com.hiromaker.simpletodo.ui.main.add

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.inputmethod.InputMethodManager
import android.widget.FrameLayout
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputEditText
import com.hiromaker.simpletodo.R


class AddTaskDialogFragment : BottomSheetDialogFragment() {

    companion object {
        const val TAG = "AddTaskDialogFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.AddTaskDialogStyle)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme)
        dialog.setContentView(R.layout.input_task_sheet)
        dialog.setOnShowListener {
            activity?.let { it1 ->
                Handler(it1.mainLooper).post {
                    dialog.findViewById<FrameLayout>(R.id.design_bottom_sheet)?.let {
                        BottomSheetBehavior.from(it).apply {
                            state = BottomSheetBehavior.STATE_EXPANDED
                        }
                    }
                }
            }
        }
        dialog.findViewById<TextInputEditText>(R.id.textField)?.also {
            it.postDelayed({
                if (it.requestFocus()) {
                    (activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).apply {
                        showSoftInput(it, InputMethodManager.SHOW_IMPLICIT)
                    }
                }
            }, 100)
        }
        return dialog
    }
}