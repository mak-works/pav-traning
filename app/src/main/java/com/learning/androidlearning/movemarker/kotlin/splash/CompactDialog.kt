package com.learning.androidlearning.movemarker.kotlin.splash

import android.app.Dialog
import android.graphics.Point
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.cardview.widget.CardView
import androidx.fragment.app.DialogFragment
import com.learning.androidlearning.R

public class CompactDialog: AppCompatDialogFragment(), View.OnClickListener {
    private val TITLE = "title"
    private val MESSAGE = "message"
    private val POSITIVE_TEXT = "pos_text"
    private val NEGATIVE_TEXT = "neg_text"

    private var message:FontTextView?=null
    private var positiveBtn:FontTextView?=null
    private var negativeBtn:FontTextView?=null
    private var positiveCv:CardView?=null
    private var negativeCv:CardView?=null

    private var positiveListener: DialogListener? = null
    private var negativeListener:DialogListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        // request a window without the title
        dialog.window.requestFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    companion object
    {
        fun newInstance(title: String?, message: String?,
                        positiveText: String, negativeText: String?): CompactDialog {
            val args = Bundle()
            args.putString(CompactDialog().TITLE, title)
            args.putString(CompactDialog().MESSAGE, message)
            args.putString(CompactDialog().POSITIVE_TEXT, positiveText)
            args.putString(CompactDialog().NEGATIVE_TEXT, negativeText ?: "")
            val fragment = CompactDialog()
            fragment.arguments = args
            return fragment
        }
    }

    fun setClickListener(positiveLis: DialogListener?, negativeLis: DialogListener?) {
        positiveListener = positiveLis
        negativeListener = negativeLis
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.dia_alert, container, false)
        message = view.findViewById(R.id.tv_message)
        positiveCv = view.findViewById(R.id.cv_ok)
        positiveBtn = view.findViewById(R.id.tv_dia_done)
        negativeCv = view.findViewById(R.id.cv_neg)
        negativeBtn = view.findViewById(R.id.tv_neg)
        negativeCv?.setOnClickListener(this)
        positiveCv?.setOnClickListener(this)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = arguments
        if (args != null) {
            message?.text = args.getString(CompactDialog().MESSAGE)
            positiveBtn?.text=args.getString(CompactDialog().POSITIVE_TEXT)
            if (TextUtils.isEmpty(args.getString(CompactDialog().NEGATIVE_TEXT))) {
                negativeCv?.visibility = View.GONE
            } else {
                negativeBtn?.text = args.getString(CompactDialog().NEGATIVE_TEXT)
            }
        }
    }

    override fun onResume() {
        val window = dialog?.window
        val size = Point()
        // Store dimensions of the screen in `size`
        val display = window?.windowManager?.defaultDisplay
        display?.getSize(size)
        // Set the width of the dialog proportional to 75% of the screen width
        window?.setLayout((size.x * 0.85).toInt(), WindowManager.LayoutParams.WRAP_CONTENT)
        window?.setGravity(Gravity.CENTER)
        super.onResume()
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.cv_ok -> if (positiveListener != null) {
                positiveListener?.onClick(this)
            } else {
                dismiss()
            }
            R.id.cv_neg -> if (negativeListener != null) {
                negativeListener?.onClick(this)
            } else {
                dismiss()
            }
        }
    }

    interface DialogListener {
        fun onClick(dialog: DialogFragment?)
    }
}