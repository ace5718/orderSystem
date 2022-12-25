package com.example.ordersystem

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val iv1:ImageView = findViewById(R.id.imageView2)
        val iv2:ImageView = findViewById(R.id.imageView3)

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