package com.learning.androidlearning.movemarker.kotlin.splash

import android.app.Activity
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.learning.androidlearning.R

class ViewUtils {

    companion object
    {
        fun showToast(activity: Activity?, message: String?) {
            showToast(activity,message,Toast.LENGTH_LONG)
        }

        fun showMaterialAlertDialog(activity: FragmentActivity?, title: String?, message: String?, positiveText: String, negativeText: String?,
                                    positiveListener: CompactDialog.DialogListener?, negativeListener: CompactDialog.DialogListener?, isCancelable: Boolean): CompactDialog
        {
            val dialog: CompactDialog = CompactDialog.newInstance(title, message, positiveText, negativeText)
            dialog.setClickListener(positiveListener, negativeListener)
            dialog.setStyle(DialogFragment.STYLE_NO_TITLE, R.style.dialog_theme)
            dialog.isCancelable = isCancelable
            dialog.show(activity!!.supportFragmentManager, "")
            return dialog
        }

        fun showToast(activity: Activity?, message: String?, toastDuration: Int) {
            if (activity!!.isFinishing) {
                return
            }
            val inflater = activity.layoutInflater
            val layout: View = inflater.inflate(R.layout.toast, null)
            val text = layout.findViewById<TextView>(R.id.text)
            text.text = message
            val toast = Toast(activity.applicationContext)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.duration = toastDuration
            toast.view = layout
            toast.show()
        }
    }




}