package com.example.ordersystem

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.NotificationCompat

class MainActivity6 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        val img: ImageView = findViewById(R.id.imageView1)
        img.setOnClickListener{
            Intent(this,MainActivity::class.java).apply {
                startActivity(this)
            }
        }

        val bundle = intent.getBundleExtra("Bundle")
        val personalData: Array<String> = bundle?.getStringArray("personalData") as Array<String>
        val orderList: String = bundle.getString("orderList").toString()
        val orderData: ArrayList<String> = bundle?.getStringArrayList("orderData") as ArrayList<String>
        val total:String = bundle.getInt("total").toString()

        setText(personalData, orderList,total)

        val btn:Button = findViewById(R.id.button)
        val btn2:Button = findViewById(R.id.button2)

        btn.setOnClickListener{
            Intent(this,MainActivity2::class.java).apply {
                val bundle = Bundle().apply {
                    putStringArray("personalData", personalData)
                    putStringArrayList("orderData", orderData)
                    putInt("total", total.toInt())

                }
                this.putExtra("returnBundle" ,bundle)
                startActivity(this)
            }
        }

        btn2.setOnClickListener{
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val channel = NotificationChannel("myChannel", "My test channel.", NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel) // ?????? channel (notification)
            // alertdialog.builder
            val builder = NotificationCompat.Builder(this, "myChannel").apply {
                setContentTitle("????????????")
                setContentText("????????????$total")
                setSubText("????????????")
                setChannelId("myChannel")
                setWhen(System.currentTimeMillis())
                setSmallIcon(R.drawable.logo)
            }
            manager.notify(1, builder.build())
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setText(personalData: Array<String>, orderList: String,total: String){
        val addressText: TextView = findViewById(R.id.textView4)
        val nameText: TextView = findViewById(R.id.textView7)
        val phoneText: TextView = findViewById(R.id.textView9)
        val orderListText: TextView = findViewById(R.id.textView11)
        val totalText: TextView = findViewById(R.id.textView13)

        addressText.text = personalData[0]
        nameText.text = personalData[1]
        phoneText.text = personalData[2]
        orderListText.text = orderList
        totalText.text = "?????????:$total"
    }
}