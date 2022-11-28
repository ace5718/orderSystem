package com.example.ordersystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val iv1:ImageView = findViewById(R.id.imageView3)
        val iv2:ImageView = findViewById(R.id.imageView2)

        iv1.setOnClickListener{
            Intent(this,MainActivity2::class.java).apply {
                startActivity(this)
            }
        }
        iv2.setOnClickListener{
            Intent(this,MainActivity2::class.java).apply {
                startActivity(this)
            }
        }
    }
}