package com.hiromaker.simpletodo.ui.main.add

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputEditText
import com.hiromaker.simpletodo.R

class AddTaskDialogFragment : BottomSheetDialogFragment() {

    companion object {
        const val TAG = "AddTaskDialogFragment"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme)
        dialog.setContentView(R.layout.input_task_sheet)
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