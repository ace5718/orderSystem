package com.example.ordersystem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment3.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment3 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var bundle: Bundle? = null
    private var page: Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    interface SendListener{
        fun sendData(changeData : Array<Int>)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank3, container, false)
        bundle = arguments //接值
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val amount1: TextView = view.findViewById(R.id.amount1)
        val amount2: TextView = view.findViewById(R.id.amount2)
        val amount3: TextView = view.findViewById(R.id.amount3)
        val amount4: TextView = view.findViewById(R.id.amount4)

        val btnIncrease1: Button = view.findViewById(R.id.btnIncrease1)
        val btnIncrease2: Button = view.findViewById(R.id.btnIncrease2)
        val btnIncrease3: Button = view.findViewById(R.id.btnIncrease3)
        val btnIncrease4: Button = view.findViewById(R.id.btnIncrease4)

        val btnDecrease1: Button = view.findViewById(R.id.btnDecrease1)
        val btnDecrease2: Button = view.findViewById(R.id.btnDecrease2)
        val btnDecrease3: Button = view.findViewById(R.id.btnDecrease3)
        val btnDecrease4: Button = view.findViewById(R.id.btnDecrease4)

        val data: ArrayList<Int>? = bundle?.getIntegerArrayList("data")
        if (data != null) {
            amount1.text = data[0].toString()
            amount2.text = data[1].toString()
            amount3.text = data[2].toString()
            amount4.text = data[3].toString()
        }

        btnIncrease1.setOnClickListener { calculate(amount1, 1, 0) }
        btnIncrease2.setOnClickListener { calculate(amount2, 1, 1) }
        btnIncrease3.setOnClickListener { calculate(amount3, 1, 2) }
        btnIncrease4.setOnClickListener { calculate(amount4, 1, 3) }

        btnDecrease1.setOnClickListener { calculate(amount1, -1, 0) }
        btnDecrease2.setOnClickListener { calculate(amount2, -1, 1) }
        btnDecrease3.setOnClickListener { calculate(amount3, -1, 2) }
        btnDecrease4.setOnClickListener { calculate(amount4, -1, 3) }
    }

    private fun calculate(amount: TextView, num: Int, btnNumber: Int) {
        val temp = amount.text.toString().toInt() + num
        if (temp >= 0){
            pushData(temp, btnNumber)
            amount.text = temp.toString()
        }
    }

    private fun pushData(changeNumber: Int, btnNumber: Int){
        val mactivity = context as MainActivity2
        mactivity.sendData(
            arrayOf(page, btnNumber, changeNumber)
        )
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment3.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment3().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}