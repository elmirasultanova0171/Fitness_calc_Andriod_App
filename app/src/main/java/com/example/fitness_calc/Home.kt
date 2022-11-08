package com.example.fitness_calc

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.fitness_calc.databinding.FragmentHomeBinding
import kotlin.math.round

class Home : Fragment() {


    private lateinit var binding: FragmentHomeBinding  //binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false) //bind
        //to make sure the button takes you to second page

            binding.btnBMI.setOnClickListener {
                //to make sure the user input is taken to the  next page
                if ((!TextUtils.isEmpty(binding.etWeight.text.toString())
                            &&(!TextUtils.isEmpty(binding.etHeight.text.toString())))
                    ) {
                    val weight = binding.etWeight.text.toString()
                    val height = binding.etHeight.text.toString()
                    val bmi = String.format("%.2f", ((weight.toFloat()/((height.toFloat()/100)
                            *(height.toFloat()/100)))))

                    val bundle = bundleOf(
                        "user_weight" to weight,
                        "user_height" to height,
                        "user_bmi" to bmi
                    )

                    it.findNavController().navigate(R.id.action_home2_to_BMI_Calc, bundle)
                } else {
                    Toast.makeText(activity, "Please enter the required values", Toast.LENGTH_LONG)
                        .show()
                }
            }

        binding.btnProtein.setOnClickListener {
            //to make sure the user input is taken to the  next page
            if ((!TextUtils.isEmpty(binding.etWeight.text.toString()))
            ) {
                val weight = binding.etWeight.text.toString()
                val protein_s = String.format("%.2f", (weight.toFloat()*0.5))
                val protein_m = String.format("%.2f",weight.toFloat()*2)
                val creatine = String.format("%.2f", (weight.toFloat()*0.3))

                val bundle = bundleOf(
                    "user_weight" to weight,
                    "user_protein" to protein_s,
                    "user_proteinM" to protein_m,
                    "user_creatine" to creatine
                )

                it.findNavController().navigate(R.id.action_home2_to_protein_creatine_calc, bundle)
            } else {
                Toast.makeText(activity, "Please enter your weight", Toast.LENGTH_LONG)
                    .show()
            }
        }

        binding.btnCal.setOnClickListener{
            if ((!TextUtils.isEmpty(binding.etWeight.text.toString())
                        &&(!TextUtils.isEmpty(binding.etHeight.text.toString())))
            ) {

                val weight = binding.etWeight.text.toString()
                val height = binding.etHeight.text.toString()

                val bundle = bundleOf(
                    "user_weight" to weight,
                    "user_height" to height
                )


                it.findNavController().navigate(R.id.action_home2_to_inputCal, bundle)
            } else {
                Toast.makeText(activity, "Please enter the required values", Toast.LENGTH_LONG)
                    .show()
            }
        }

        return binding.root  //bind


    }



}



