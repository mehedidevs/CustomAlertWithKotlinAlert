package com.cit.customalertwithkotlinextensions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private var notesDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.showAlertBtn).setOnClickListener {
            showDialog(this,"Procced", "No", R.drawable.ic_baseline_adb_24,
                positiveFun = {
                    Toast.makeText(this@MainActivity, "Cliked Yes", Toast.LENGTH_LONG).show()

                }, negativeFun = {
                    Toast.makeText(this@MainActivity, "Cliked NO", Toast.LENGTH_LONG).show()
                }, neutralFUn = {

                })

        }


    }

    private fun showDialog() {

        if (notesDialog == null)

            notesDialog = showNotesAlertDialog {

                cancelable = true
                setContent {


                }


                closeIconClickListener {
                    showVLog("Notes Dialog close icon clicked")

                    Toast.makeText(this@MainActivity, "Cliked", Toast.LENGTH_LONG).show()
                }

                doneIconClickListener {
                    Toast.makeText(this@MainActivity, "Cliked", Toast.LENGTH_LONG).show()
                    showVLog("Notes Dialog done icon clicked")
                }
            }
        //  and showing
        notesDialog?.show()
    }


}