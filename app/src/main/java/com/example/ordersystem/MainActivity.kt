package com.example.ordersystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.util.rangeTo


class FoodData (_name: String, _price: Int, _imgUrl: String,_type: Int , _count :Int){
    val name = _name
    val price = _price
    val imgUrl = _imgUrl
    val type = _type
    var count = _count
}

class MainData(){
    var orderType = 0
    var foodType = ArrayList<String>()
    var foodDataArray = ArrayList<FoodData>()
    var total = 0
    var nowFoodType = 0

    init {
        this.getFoodData()
        this.getFoodType()
    }

    private fun getFoodData(){
        val data = arrayOf(
            arrayOf("滷肉飯", 60, "", 0),
            arrayOf("控肉販", 60, "", 0),
            arrayOf("豬腳飯", 60, "", 0),
            arrayOf("白　飯", 10, "", 0),

            arrayOf("煲青菜", 30, "", 1),
            arrayOf("皮蛋豆腐", 40, "", 1),
            arrayOf("滷豬腳", 75, "", 1),
            arrayOf("荷包蛋", 10, "", 1),

            arrayOf("奶　烙", 40, "", 2),
            arrayOf("冰淇淋", 40, "", 2),
            arrayOf("手工布丁", 40, "", 2),
            arrayOf("花生麻糬", 10, "", 2),

            arrayOf("可口可樂", 30, "", 3),
            arrayOf("百事可樂", 30, "", 3),
            arrayOf("雪　碧", 30, "", 3),
            arrayOf("黑松沙士", 30, "", 3),
        )

        for (i in 0 .. (data.size - 1).toInt()){
            this.foodDataArray.add(FoodData(data[i][0].toString(),
                data[i][1].toString().toInt(),
                data[i][2].toString(),
                data[i][3].toString().toInt(),0))
        }
    }

    private fun getFoodType(){
        val data = arrayOf("主食", "小菜", "點心", "飲品")

        for (i in 0 .. (data.size -1).toInt()){
            this.foodType.add(data[i])
        }
    }


}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var data = MainData()

        val iv1:ImageView = findViewById(R.id.imageView3)
        val iv2:ImageView = findViewById(R.id.imageView2)

        iv1.setOnClickListener{
            Intent(this,MainActivity2::class.java).apply {
                startActivity(this)
            }
        }
        iv2.setOnClickListener{
            Intent(this,MainActivity2::class.java).apply {
                startActivity(this)
            }
        }
    }
}