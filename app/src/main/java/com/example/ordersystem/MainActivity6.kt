package com.example.ordersystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        val bundle = intent.getBundleExtra("TextBundle")


        val totalText: TextView = findViewById(R.id.textView3)

        //textList.text = bundle?.getString("data")
        totalText.text = "總金額: ${bundle?.getInt("total").toString()}"
    }
}