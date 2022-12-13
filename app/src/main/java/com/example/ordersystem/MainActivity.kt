package com.example.ordersystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.util.rangeTo

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val iv1:ImageView = findViewById(R.id.imageView3)
        val iv2:ImageView = findViewById(R.id.imageView2)

        iv1.setOnClickListener{
            Intent(this,MainActivity2::class.java).apply {
                val bundle = Bundle()
                bundle.putString("type", "1")
                intent.putExtras(bundle)
                startActivity(this)
            }
        }

        iv2.setOnClickListener{
            Intent(this,MainActivity2::class.java).apply {
                val bundle = Bundle()
                bundle.putString("type", "2")
                intent.putExtras(bundle)
                startActivity(this)
            }
        }
    }
}