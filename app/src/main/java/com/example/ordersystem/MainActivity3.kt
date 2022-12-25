package com.example.ordersystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val img: ImageView = findViewById(R.id.imageView1)
        img.setOnClickListener{
            Intent(this,MainActivity::class.java).apply {
                startActivity(this)
            }
        }

        var bundle = intent.getBundleExtra("Bundle")
        val type = bundle?.getInt("type")

        if (type != null) {
            checkFragment(type)

            val btn: Button = findViewById(R.id.button)
            btn.setOnClickListener{
                val name:String = findViewById<EditText>(R.id.editTextTextPersonName).text.toString()
                val phoneNumber:String = findViewById<EditText>(R.id.editTextTextPersonName2).text.toString()
                var address = ""
                when(type){
                    1 -> address = "220新北市板橋區文化路一段313號"
                    2 -> address = findViewById<EditText>(R.id.editTextTextPersonName5).text.toString()
                }

                Intent(this,MainActivity2::class.java).apply {
                    bundle = Bundle().apply {
                        putStringArray("personalData", arrayOf(address, name, phoneNumber))
                    }
                    this.putExtra("Bundle" ,bundle)
                    startActivity(this)
                }
            }
        }
    }

    private fun checkFragment(type: Int){
        when(type){
            1 -> changeFragment(BlankFragment8())
            2 -> changeFragment(BlankFragment7())
        }
    }

    private fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView3, fragment)
            commit()
        }
    }
}