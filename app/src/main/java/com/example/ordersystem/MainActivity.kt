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

        iv1.setOnClickListener{ changePage(1) }
        iv2.setOnClickListener{ changePage(2) }
    }

    private fun changePage(type: Int){
        Intent(this,MainActivity3::class.java).apply {
            val bundle = Bundle().apply {
                putInt("type", type)
            }
            this.putExtra("Bundle" ,bundle)
            startActivity(this)
        }
    }
}