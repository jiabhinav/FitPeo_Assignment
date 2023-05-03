package com.app.fitpeo.base
import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import com.app.fitpeo.R


open class BaseActivity: AppCompatActivity() {

    var alertDialog: AlertDialog?=null




    var pDialog: Dialog? = null

    fun showDialogs(context: Activity) {
        pDialog = Dialog(context)
        pDialog?.setContentView(R.layout.progress_bar_layout)
        pDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        pDialog!!.setCancelable(false)
        if (!(context).isFinishing) {
            if (!pDialog!!.isShowing) {
                pDialog!!.show()
            }
        }

        pDialog!!.setOnCancelListener { pDialog!!.dismiss() }
        pDialog!!.setOnKeyListener { dialog, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                if (pDialog != null) pDialog!!.dismiss()
            }
            true
        }
    }

    fun dismiss() {
        if (pDialog != null) {
            pDialog!!.dismiss()
            pDialog = null
        }
    }

    override fun onPause() {
        super.onPause()
    }


    override fun onResume() {
        super.onResume()

    }


    fun loadingProgress(isLoding:Boolean)
    {
        if(isLoding) {
            showDialogs(this)
        } else {
            dismiss()
        }
    }



    fun checkConnection(context: Activity?) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("No internet Connection")
        builder.setMessage("Please turn on internet connection to continue")
        builder.setCancelable(false)
        builder/*.setPositiveButton(
            "Retry!!"
        ) { dialog, which ->
            retryCallAPI()
        }*/.setNegativeButton(
            "Close"
        ) { dialog, which -> }
        alertDialog = builder.create()
        alertDialog?.setCancelable(false)
        alertDialog?.show()
    }


}