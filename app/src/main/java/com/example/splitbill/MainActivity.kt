package com.example.splitbill

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    private lateinit var subtotal : EditText
    private lateinit var tipPercent : EditText
    private lateinit var ppl : EditText
    private lateinit var calcBtn : Button
    private lateinit var subtotalTV : TextView
    private lateinit var tipTV : TextView
    private lateinit var totalTV : TextView
    private lateinit var pplNum : TextView
    private lateinit var tipEach : TextView
    private lateinit var totalEach : TextView
    private lateinit var clearBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //views
        //inputs
        subtotal = findViewById(R.id.subtotal)
        tipPercent = findViewById(R.id.tip_percent)
        ppl = findViewById(R.id.ppl_num)
        calcBtn = findViewById(R.id.calc_button)
        //outputs
        subtotalTV = findViewById(R.id.subtotal_show)
        tipTV = findViewById(R.id.tip_show)
        totalTV = findViewById(R.id.grand_total)
        pplNum = findViewById(R.id.num_ppl)
        tipEach = findViewById(R.id.tip_each)
        totalEach = findViewById(R.id.total_each)
        clearBtn = findViewById(R.id.clear_button)

        calcBtn.setOnClickListener { calculate() }
        clearBtn.setOnClickListener {
            //clear all
            subtotal.setText("")
            tipPercent.setText("")
            ppl.setText("")

            subtotalTV.text = ""
            tipTV.text = ""
            totalTV.text = ""
            pplNum.text = ""
            tipEach.text = ""
            totalEach.text = ""
        }
    }

    private fun calculate(){
        val sub = subtotal.text.toString().toDouble()
        val tPercent = tipPercent.text.toString().toDouble()
        val pNum = ppl.text.toString().toInt()

        //calculations
        Log.i("Tip percent", "$tPercent")

        val tip = (tPercent / 100) * sub
        Log.i("Tip Amt", "$tip")

        val total = sub + tip

        //each
        val eTip = tip / pNum.toDouble()
        val eTotal = total / pNum.toDouble()

        //display
        subtotalTV.text = String.format("%.2f", sub)
        tipTV.text = String.format("%.2f", tip)
        totalTV.text = String.format("%.2f", total)

        val str = "($pNum)"
        pplNum.text = str
        tipEach.text = String.format("%.2f", eTip)
        totalEach.text = String.format("%.2f", eTotal)

        //show clear button
        clearBtn.visibility = View.VISIBLE
    }//calculate
}