package com.example.ordersystem

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity2 : AppCompatActivity(),
    BlankFragment.SendListener,
    BlankFragment2.SendListener,
    BlankFragment3.SendListener,
    BlankFragment4.SendListener{
    private var data = arrayOf(
        arrayOf( //第一頁
            arrayOf(60, 0),  //價格 數量
            arrayOf(60, 0),
            arrayOf(60, 0),
            arrayOf(10, 0)
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
    private var dataName = arrayOf(
        arrayOf("滷肉飯", "焢肉飯", "豬腳飯", "白飯"),
        arrayOf("燙青菜", "皮蛋豆腐", "滷豬腳", "荷包蛋"),
        arrayOf("奶酪", "冰淇淋", "手工布丁", "花生麻糬"),
        arrayOf("可口可樂", "百事可樂", "雪碧", "黑松沙士")
    ) //項目名稱
    private var dataTemp: ArrayList<Int> = ArrayList() //向 fragment 傳送 data 資料的載體
    private var totalTextView: TextView? = null
    private var total: Int = 0 //總價格

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btn01: Button = findViewById(R.id.but01)
        val btn02: Button = findViewById(R.id.but02)
        val btn03: Button = findViewById(R.id.but03)
        val btn04: Button = findViewById(R.id.but04)
        val btn05: Button = findViewById(R.id.button5)

        totalTextView = findViewById(R.id.textView3)
        setConstTextView(0)

        btn01.setOnClickListener { changeFragment(BlankFragment(), 0) }
        btn02.setOnClickListener { changeFragment(BlankFragment2(), 1) }
        btn03.setOnClickListener { changeFragment(BlankFragment3(), 2) }
        btn04.setOnClickListener { changeFragment(BlankFragment4(), 3) }

        btn05.setOnClickListener {
            Intent(this,MainActivity6::class.java).apply {
                val bundle = Bundle().apply {
                    putString("data", getOrderData())
                    putInt("total", total)
                }
                this.putExtra("TextBundle" ,bundle)
                startActivity(this)
            }
        }
    }

    override fun sendData(changeData: Array<Int>) {
        val price = data[changeData[0]][changeData[1]][0]
        val originalNumber = data[changeData[0]][changeData[1]][1]
        setConstTextView( (changeData[2] - originalNumber) * price )

        //data[哪一頁][哪一個被動到了][1] = 動了多少
        data[changeData[0]][changeData[1]][1] = changeData[2]
    }

    private fun changeFragment(fragment: Fragment, page: Int){
        setDataTemp(data[page])
        Log.d("test", dataTemp[0].toString())
        val bundle = Bundle()
        bundle.putIntegerArrayList("data", dataTemp)
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, fragment)
            commit()
        }
    }

    private fun setDataTemp(data: Array<Array<Int>>){
        //Gdata預計是 [第一個選擇的數量, 第二個選擇的數量 ... ]
        dataTemp.clear()
        data.forEach {
            dataTemp.add(it[1])
        }
    }

    private fun getOrderData(): String{
        var str = ""
        data.forEachIndexed {i, element ->
            element.forEachIndexed { j, element ->
                if ( element[1] > 0 ){
                    str += "${element[1]} X ${dataName[i][j]}　$ ${element[0] * element[1]}\n"
                }
            }
        }
        Log.d("test", str)
        return str
    }

    @SuppressLint("SetTextI18n")
    private fun setConstTextView(addTotal: Int){
        total += addTotal
        totalTextView?.text = "總金額： $total"
    }
}