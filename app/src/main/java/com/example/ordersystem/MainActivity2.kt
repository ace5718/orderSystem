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

class MainActivity2 : AppCompatActivity() {
    class FoodData (_name: String, _price: Int, _imgUrl: String,_type: Int , _count :Int){
        val name = _name
        val price = _price
        val imgUrl = _imgUrl
        val type = _type
        var count = _count
    }

    class MainData(){
        var foodDataArray = ArrayList<FoodData>() //食物類型
        var foodType = ArrayList<String>() //食物資料
        var nowFoodType = 0 //現在選擇的食物類型
        var orderType = 0 //點餐類型
        var total = 0 //總金額

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val data = MainData()

        val typeView = findViewById<LinearLayout>(R.id.foodTypeVIew)
        val testbtn = findViewById<Button>(R.id.but01)

        val btn = Button(this)
        btn.width = 100
        btn.height = 100
        btn.text = "小菜"
        typeView.addView(btn)

        //android:id="@+id/but02"
        //                    android:layout_width="100dp"
        //                    android:layout_height="100dp"
        //                    android:layout_marginStart="5dp"
        //                    android:layout_marginTop="5dp"
        //                    android:layout_marginEnd="5dp"
        //                    android:layout_marginBottom="5dp"
        //                    android:layout_weight="0"
        //                    android:text="小菜"
        //                    android:textAlignment="center"
        //                    android:textSize="26sp"
    }
}