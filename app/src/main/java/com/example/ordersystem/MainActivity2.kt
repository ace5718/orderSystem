package com.example.ordersystem

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import androidx.core.view.marginBottom
import androidx.core.view.marginEnd
import androidx.core.view.marginStart
import androidx.core.view.marginTop

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val but02: Button = findViewById(R.id.but02)
        val but03: Button = findViewById(R.id.but03)
        val but04: Button = findViewById(R.id.but04)

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

        but04.setOnClickListener {
            Intent(this,MainActivity5::class.java).apply {
                startActivity(this)
            }
        }
    }
}