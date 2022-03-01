package com.example.splitbill

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class UpdateDialog: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val linkTV = TextView(this.context)
        linkTV.text = this.getText(R.string.update_msg)

        //link to site to download updated version
        linkTV.setOnClickListener {
            val uri = Uri.parse("https://appsbyanl.herokuapp.com/")
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }
        //style text view
        linkTV.gravity = Gravity.CENTER
        linkTV.setPadding(0,15,0,0)
        linkTV.setTextSize(TypedValue.COMPLEX_UNIT_SP,20F)

        return AlertDialog.Builder(activity)
            .setTitle(R.string.update)
            .setCancelable(true)
            .setPositiveButton(R.string.dismiss_btn,null)
            .setView(linkTV)
            .create()
    }
}