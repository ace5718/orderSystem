package com.example.ordersystem

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.app.NotificationCompat

class MainActivity6 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        val bundle = intent.getBundleExtra("Bundle")
        val personalData: Array<String> = bundle?.getStringArray("personalData") as Array<String>
        val orderData: String = bundle.getString("orderData").toString()
        val total:String = bundle.getInt("total").toString()

        setText(personalData, orderData,total)

        val btn:Button = findViewById(R.id.button)
        val btn2:Button = findViewById(R.id.button2)

        btn.setOnClickListener{
            Intent(this,MainActivity2::class.java).apply {
                startActivity(this)
            }
        }

        btn2.setOnClickListener{
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val channel = NotificationChannel("myChannel", "My test channel.", NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel) // 建立 channel (notification)
            // alertdialog.builder
            val builder = NotificationCompat.Builder(this, "myChannel").apply {
                setContentTitle("完成訂單")
                setContentText("總共花了$total")
                setSubText("訂單提示")
                setChannelId("myChannel")
                setWhen(System.currentTimeMillis())
                setSmallIcon(R.drawable.logo)
            }
            manager.notify(1, builder.build())
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setText(personalData: Array<String>, orderData: String,total: String){
        val addressText: TextView = findViewById(R.id.textView4)
        val nameText: TextView = findViewById(R.id.textView7)
        val phoneText: TextView = findViewById(R.id.textView9)
        val orderList: TextView = findViewById(R.id.textView11)
        val totalText: TextView = findViewById(R.id.textView13)

        addressText.text = personalData[0]
        nameText.text = personalData[1]
        phoneText.text = personalData[2]
        orderList.text = orderData
        totalText.text = "總金額:$total"
    }
}