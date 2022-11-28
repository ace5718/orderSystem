package com.example.ordersystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val but01: Button = findViewById(R.id.but01)
        val but02: Button = findViewById(R.id.but02)
        val but03: Button = findViewById(R.id.but03)

        but01.setOnClickListener {
            Intent(this,MainActivity2::class.java).apply {
                startActivity(this)
            }
        }

        but02.setOnClickListener {
            Intent(this,MainActivity3::class.java).apply {
                startActivity(this)
            }
        }

        but03.setOnClickListener {
            Intent(this,MainActivity4::class.java).apply {
                startActivity(this)
            }
        }
    }
}