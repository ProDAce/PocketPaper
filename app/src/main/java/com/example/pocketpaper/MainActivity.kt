package com.example.pocketpaper

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    lateinit var iv: ImageView
    var n = 0
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mypref = Preference(this)
        count = mypref.getCount()

        var tv1: EditText = findViewById(R.id.textView)
        var tv2: EditText = findViewById(R.id.textView2)
        iv = findViewById(R.id.iv)

        tv1.setText(count.toString())
        tv2.setText(count.toString())

        doColor()

        val btn: Button = findViewById(R.id.btn)
        btn.setOnClickListener{


            val S = tv2.text.toString()
            count = S.toInt()
            mypref.setNum(count)
            doColor()
        }

    }

    fun doColor()   {
        if(count%2==0)
            iv.setColorFilter(ContextCompat.getColor(this, R.color.colorPrimary))
        else
            iv.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent))
    }


}
