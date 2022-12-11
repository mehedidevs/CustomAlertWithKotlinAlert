package com.cit.customalertwithkotlinextensions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText

class MyCustomDialog(private val context: Context, var title: String) : BaseDialog() {
    override val dialogView: View =
        LayoutInflater.from(context).inflate(R.layout.notes_dialog, null)


    override val builder: AlertDialog.Builder = AlertDialog.Builder(context).setView(dialogView)


    //  done icon
    private val doneIcon: Button = dialogView.findViewById(R.id.done_icon)

    //  close icon
    private val closeIcon: Button = dialogView.findViewById(R.id.close_icon)
    private val titleTv: TextView = dialogView.findViewById<TextView?>(R.id.titleTv)


    fun setContent(func: (() -> Unit)? = null) = with(titleTv) {
        myContentSetter(func)
    }

    private fun myContentSetter(func: (() -> Unit)?) {
        func!!.invoke()
        titleTv.text = title

    }

    //  closeIconClickListener with listener
    fun closeIconClickListener(func: (() -> Unit)? = null) =
        with(closeIcon) {
            setClickListenerToDialogIcon(func)
        }

    //  doneIconClickListener with listener
    fun doneIconClickListener(func: (() -> Unit)? = null) =
        with(doneIcon) {
            setClickListenerToDialogIcon(func)
        }

    //  view click listener as extension function
    private fun View.setClickListenerToDialogIcon(func: (() -> Unit)?) =
        setOnClickListener {
            func?.invoke()
            dialog?.dismiss()
        }
}