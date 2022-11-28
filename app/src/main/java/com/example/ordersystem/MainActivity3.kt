package com.example.ordersystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val but01: Button = findViewById(R.id.but01)
        val but03: Button = findViewById(R.id.but03)
        val but04: Button = findViewById(R.id.but04)

        but01.setOnClickListener {
            Intent(this,MainActivity2::class.java).apply {
                startActivity(this)
            }
        }

        but03.setOnClickListener {
            Intent(this,MainActivity4::class.java).apply {
                startActivity(this)
            }
        }

        but04.setOnClickListener {
            Intent(this,MainActivity5::class.java).apply {
                startActivity(this)
            }
        }
    }
}