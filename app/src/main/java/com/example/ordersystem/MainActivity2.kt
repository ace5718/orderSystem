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
import androidx.fragment.app.Fragment

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val but01: Button = findViewById(R.id.but01)
        val but02: Button = findViewById(R.id.but02)
        val but03: Button = findViewById(R.id.but03)
        val but04: Button = findViewById(R.id.but04)

        val f1 = BlankFragment()
        val f2 = BlankFragment2()
        val f3 = BlankFragment3()
        val f4 = BlankFragment4()

        but01.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, f1)
                commit()
            }
        }

        but02.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, f2)
                .commit()
        }

        but03.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, f3)
                .commit()
        }

        but04.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, f4)
                .commit()
        }
    }
}