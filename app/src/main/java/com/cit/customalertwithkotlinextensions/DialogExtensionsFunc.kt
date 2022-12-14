package com.cit.customalertwithkotlinextensions

import android.R
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog


inline fun Activity.showNotesAlertDialog(func: MyCustomDialog.() -> Unit): AlertDialog {
    return MyCustomDialog(this, "Custom").apply {
        func()
    }.create()
}

fun Any.showVLog(log: String) = Log.v(this::class.java.simpleName, log)


fun Activity.showDialog(
    context: Context,
    yesContent: String,
    noContent: String,
    resId: Int,
    positiveFun: () -> Unit,
    negativeFun: () -> Unit,
    neutralFUn: () -> Unit?
) {

    val deleteDialogView: View = LayoutInflater.from(context)
        .inflate(com.cit.customalertwithkotlinextensions.R.layout.notes_dialog, null)
    val deleteDialog: AlertDialog = AlertDialog.Builder(context).setCancelable(false).create()
    deleteDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    deleteDialog.setView(deleteDialogView)
    val yesButton =
        deleteDialogView.findViewById<Button>(com.cit.customalertwithkotlinextensions.R.id.yesBtn)
    val noButton =
        deleteDialogView.findViewById<Button>(com.cit.customalertwithkotlinextensions.R.id.noBtn)
    val logoIcon =
        deleteDialogView.findViewById<ImageView>(com.cit.customalertwithkotlinextensions.R.id.topIcon)
    yesButton.text = yesContent
    noButton.text = noContent
    logoIcon.setImageResource(resId)


    yesButton.setOnClickListener {
        positiveFun.invoke()
        deleteDialog.dismiss()
    }
    noButton.setOnClickListener {
        negativeFun.invoke()
        deleteDialog.dismiss()
    }



    deleteDialog.show()


}