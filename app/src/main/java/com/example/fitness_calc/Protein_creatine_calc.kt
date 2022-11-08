package com.example.fitness_calc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitness_calc.databinding.FragmentBMICalcBinding
import com.example.fitness_calc.databinding.FragmentProteinCreatineCalcBinding

class protein_creatine_calc : Fragment() {

    private lateinit var binding: FragmentProteinCreatineCalcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProteinCreatineCalcBinding.inflate(inflater, container, false)

        val inputW = requireArguments().getString("user_weight")
        val inputP = requireArguments().getString("user_protein")
        val inputPm = requireArguments().getString("user_proteinM")
        val inputC = requireArguments().getString("user_creatine")
        val w="$inputW kg"
        val p="$inputP g " +
                "to" +
                " $inputPm g"
        val c="$inputC g"

        binding.tvWeight2.text = w
        binding.tvProtein.text = p
        binding.tvCreatine.text = c

        return binding.root

    }
}