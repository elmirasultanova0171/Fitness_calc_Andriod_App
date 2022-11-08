package com.example.fitness_calc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitness_calc.databinding.FragmentBMICalcBinding
import com.example.fitness_calc.databinding.FragmentCalorieCalcBinding
import com.example.fitness_calc.databinding.FragmentProteinCreatineCalcBinding

class calorie_calc : Fragment() {
    private lateinit var binding: FragmentCalorieCalcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalorieCalcBinding.inflate(inflater, container, false)

        val calories = (requireArguments().getString("user_cal"))
        val min_cal = requireArguments().getString("min_cal")
        val max_cal = requireArguments().getString("max_cal")
        val min="$calories kcal"
        val max="$min_cal kcal"
        val c="$max_cal kcal"
       binding.tvNormalCal.text=c
        binding.tvMaxCal.text=max
        binding.tvMinCal.text=min

        return binding.root
    }


}