package com.cit.customalertwithkotlinextensions

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.util.Log
import androidx.appcompat.app.AlertDialog


inline fun Activity.showNotesAlertDialog(func: MyCustomDialog.() -> Unit): AlertDialog {
    return MyCustomDialog(this, "Custom").apply {
        func()
    }.create()
}

fun Any.showVLog(log: String) = Log.v(this::class.java.simpleName, log)
fun Activity.createDialog(context: Context, func1: () -> Unit, func2: () -> Unit) {
    var builder = AlertDialog.Builder(context)
    builder.setTitle("Shake Detected")
    builder.setMessage("Message")
    builder.setPositiveButton("Yes",
        DialogInterface.OnClickListener { dialog, whichButton -> //do something
            func1.invoke()
            dialog.dismiss()
        })
    builder.setNegativeButton("No",
        DialogInterface.OnClickListener { dialog, whichButton -> //do something
            func2.invoke()
            dialog.dismiss()
        })
    builder.setCancelable(false)
    var alert = builder.create()

    alert.show()
}