package com.example.ordersystem

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.Arrays

class MainActivity2 : AppCompatActivity(),
    BlankFragment.SendListener,
    BlankFragment2.SendListener,
    BlankFragment3.SendListener,
    BlankFragment4.SendListener{
    private var Gdata: ArrayList<Int>? = ArrayList()
    //private lateinit var Gconst: Int
    private lateinit var data: Array<Array<Array<Int>>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //Gconst = 0 //總價格
        data = arrayOf(
            arrayOf( //第一頁
                arrayOf(60, 0),  //價格 數量
                arrayOf(10, 0),
                arrayOf(60, 0),
                arrayOf(60, 0)
            ),
            arrayOf( //第二頁
                arrayOf(30, 0),
                arrayOf(40, 0),
                arrayOf(75, 0),
                arrayOf(10, 0)
            ),
            arrayOf( //第三頁
                arrayOf(40, 0),
                arrayOf(35, 0),
                arrayOf(50, 0),
                arrayOf(30, 0)
            ),
            arrayOf( //第四頁
                arrayOf(30, 0),
                arrayOf(30, 0),
                arrayOf(30, 0),
                arrayOf(30, 0)
            )
        ) //各頁數量統計

        val but01: Button = findViewById(R.id.but01)
        val but02: Button = findViewById(R.id.but02)
        val but03: Button = findViewById(R.id.but03)
        val but04: Button = findViewById(R.id.but04)

        val f1 = BlankFragment()
        val f2 = BlankFragment2()
        val f3 = BlankFragment3()
        val f4 = BlankFragment4()



        but01.setOnClickListener {
            setGdata(data[0], 0)
            val bundle = Bundle()
            bundle.putIntegerArrayList("data", Gdata)
            f1.arguments = bundle

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

    override fun sendData(data: ArrayList<Int>) {
        Gdata = data
        Log.d("test", Gdata?.get(1).toString())
        setData()
        //Gconst = const
    }

    private fun setGdata(data: Array<Array<Int>>, page: Int){
        //Gdata預計是 [ 哪一頁, 第一個選擇的數量, 第二個選擇的數量 ... ]
        Gdata?.clear()
        Gdata?.add(page)
        data.forEach {
            Gdata?.add(it[1])
        }
    }

    private fun setData(){

    }
}