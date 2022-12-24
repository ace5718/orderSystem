package com.example.ordersystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.core.util.rangeTo
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val iv1:ImageView = findViewById(R.id.imageView2)
        val iv2:ImageView = findViewById(R.id.imageView6)

        iv1.setOnClickListener{
            Intent(this,MainActivity3::class.java).apply {
                val bundle = Bundle().apply {
                    putInt("type", 1) //外帶
                }
                this.putExtra("TextBundle" ,bundle)
                startActivity(this)
            }
        }

        iv2.setOnClickListener{
            Intent(this,MainActivity3::class.java).apply {
                val bundle = Bundle().apply {
                    putInt("type", 2) //外送
                }
                this.putExtra("TextBundle" ,bundle)
                startActivity(this)
            }
        }
    }
}