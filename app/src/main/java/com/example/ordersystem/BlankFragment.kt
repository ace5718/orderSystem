package com.example.ordersystem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */



class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etAmount1: EditText = view.findViewById(R.id.etAmount1)
        val etAmount2: EditText = view.findViewById(R.id.etAmount2)
        val etAmount3: EditText = view.findViewById(R.id.etAmount3)
        val etAmount4: EditText = view.findViewById(R.id.etAmount4)

        val btnIncrease1:Button = view.findViewById(R.id.btnIncrease1)
        val btnIncrease2:Button  = view.findViewById(R.id.btnIncrease2)
        val btnIncrease3:Button  = view.findViewById(R.id.btnIncrease3)
        val btnIncrease4:Button  = view.findViewById(R.id.btnIncrease4)

        val btnDecrease1: Button = view.findViewById(R.id.btnDecrease1)
        val btnDecrease2: Button = view.findViewById(R.id.btnDecrease2)
        val btnDecrease3: Button = view.findViewById(R.id.btnDecrease3)
        val btnDecrease4: Button = view.findViewById(R.id.btnDecrease4)

        btnIncrease1.setOnClickListener { calculate(etAmount1, 1) }
        btnIncrease2.setOnClickListener { calculate(etAmount2, 1) }
        btnIncrease3.setOnClickListener { calculate(etAmount3, 1) }
        btnIncrease4.setOnClickListener { calculate(etAmount4, 1) }

        btnDecrease1.setOnClickListener { calculate(etAmount1, -1) }
        btnDecrease2.setOnClickListener { calculate(etAmount2, -1) }
        btnDecrease3.setOnClickListener { calculate(etAmount3, -1) }
        btnDecrease4.setOnClickListener { calculate(etAmount4, -1) }
    }

    private fun calculate(etAmount: EditText, num: Int) {
        val temp = etAmount.text.toString().toInt() + num
        if (temp >= 0){
            etAmount.setText(temp.toString())
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}


