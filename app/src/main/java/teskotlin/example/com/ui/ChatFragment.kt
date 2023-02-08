package teskotlin.example.com.ui

import android.os.Bundle
import android.text.method.TextKeyListener
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import teskotlin.example.com.R
import net.objecthunter.exp4j.ExpressionBuilder
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChatFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChatFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var Expression: TextView
    private lateinit var Result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        var txtAngka = R.id.tvSeven
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chat,container,false)

        /*Nomor*/
        val tvZero = view.findViewById<TextView>(R.id.tvZero)
        val tvOne = view.findViewById<TextView>(R.id.tvOne)
        val tvTwo = view.findViewById<TextView>(R.id.tvTwo)
        val tvThree = view.findViewById<TextView>(R.id.tvThree)
        val tvFour = view.findViewById<TextView>(R.id.tvFour)
        val tvFive = view.findViewById<TextView>(R.id.tvFive)
        val tvSix = view.findViewById<TextView>(R.id.tvSix)
        val tvSeven = view.findViewById<TextView>(R.id.tvSeven)
        val tvEight = view.findViewById<TextView>(R.id.tvEight)
        val tvNine = view.findViewById<TextView>(R.id.tvNine)

        /*Operator*/
        val tvEquals = view.findViewById<TextView>(R.id.tvEquals)
        val tvMinus = view.findViewById<TextView>(R.id.tvMinus)
        val tvPlus = view.findViewById<TextView>(R.id.tvPlus)
        val tvMul = view.findViewById<TextView>(R.id.tvMul)
        val tvClear = view.findViewById<TextView>(R.id.tvClear)
        val tvDivide = view.findViewById<TextView>(R.id.tvDivide)

        Expression = view.findViewById<TextView>(R.id.tvExpression)
        Result = view.findViewById<TextView>(R.id.tvResult)






        tvZero.setOnClickListener{
            evaluateExpression("0", clear = true)
        }
        tvOne.setOnClickListener{
            evaluateExpression("1", clear = true)
        }
        tvTwo.setOnClickListener{
            evaluateExpression("2", clear = true)
        }
        tvThree.setOnClickListener{
            evaluateExpression("3", clear = true)
        }
        tvFour.setOnClickListener{
            evaluateExpression("4", clear = true)
        }
        tvFive.setOnClickListener{
            evaluateExpression("5", clear = true)
        }
        tvSix.setOnClickListener{
            evaluateExpression("6", clear = true)
        }
        tvSeven.setOnClickListener{
            evaluateExpression("7", clear = true)
        }
        tvEight.setOnClickListener{
            evaluateExpression("8", clear = true)
        }
        tvNine.setOnClickListener{
            evaluateExpression("9", clear = true)
        }

        /*Operator*/
        tvPlus.setOnClickListener {
            evaluateExpression("+", clear = true)
        }

        tvMinus.setOnClickListener {
            evaluateExpression("-", clear = true)
        }

        tvMul.setOnClickListener {
            evaluateExpression("*", clear = true)
        }

        tvClear.setOnClickListener {
            Expression.text = ""
            Result.text = ""
        }

        tvDivide.setOnClickListener {
            evaluateExpression("/", clear = true)
        }

        tvEquals.setOnClickListener {
            val text = Expression.text.toString()
            val expression = ExpressionBuilder(text).build()

            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                Result.text = longResult.toString()
            } else {
                Result.text = result.toString()
            }
        }


        return view

    }

    fun evaluateExpression(string: String, clear: Boolean) {
        if(clear) {
//            Result.text = ""
            Expression.append(string)
            if(Result.text != null){
                
            }
        } else {
            Expression.append(Result.text)
            Expression.append(string)
//            Result.text = ""
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChatFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
                ChatFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}