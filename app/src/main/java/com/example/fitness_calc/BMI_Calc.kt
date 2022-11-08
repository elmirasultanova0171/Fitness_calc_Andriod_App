package com.example.fitness_calc

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.fitness_calc.databinding.FragmentBMICalcBinding

class BMI_Calc : Fragment() {
    private lateinit var binding: FragmentBMICalcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBMICalcBinding.inflate(inflater, container, false)

        val inputW = requireArguments().getString("user_weight")
        val inputH = requireArguments().getString("user_height")
        val inputB = (requireArguments().getString("user_bmi"))
        val w="$inputW kg"
        val p="$inputH cm"

        binding.tvWeight.text = w
        binding.tvHeight.text = p
        binding.tvBMI.text = inputB
        if (inputB != null) {
            binding.tvResult.text = resultStr(inputB.toFloat())
        }
        return binding.root

    }


    private fun resultStr(bmi:Float): String {

        var resultText = ""

        when{
            bmi<18.50 ->{
                resultText = "You are underweight"
            }
            bmi in 18.50..24.99->{
                resultText = "You are healthy"
            }
            bmi in 25.00..29.99->{
                resultText = "You are overweight"
            }
            bmi > 29.99-> {
                resultText = "You are obese"
            }

        }
         return resultText
    }
}