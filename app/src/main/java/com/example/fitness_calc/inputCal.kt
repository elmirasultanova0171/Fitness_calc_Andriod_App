package com.example.fitness_calc

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.fitness_calc.databinding.FragmentInputCalBinding

class inputCal : Fragment() {

    private lateinit var binding: FragmentInputCalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInputCalBinding.inflate(inflater, container, false)

        val inputW = requireArguments().getString("user_weight")
        val inputH = requireArguments().getString("user_height")

        var cal="1"

        binding.btnMan.setOnClickListener {
            val age= binding.etAge.text.toString()
                if ((!TextUtils.isEmpty(binding.etAge.text.toString()))
                    &&(binding.rbMan.isChecked||binding.rbWoman.isChecked))
                {
                    if(binding.rbMan.isChecked){
                      cal= ((66+inputW!!.toFloat()* 13.7)
                            +(inputH!!.toFloat() * 5) - (6.8 * age.toFloat())).toString()
                    }

                    if(binding.rbWoman.isChecked){
                        cal = ((655 + (inputW!!.toFloat() * 9.6)+
                                (inputH!!.toFloat() * 1.8) - (4.7 * age.toFloat()))).toString()
                    }

                    val normCal = cal
                    val minCal = (cal.toFloat() - 300).toString()
                    val maxCal = (cal.toFloat() + 300).toString()

                    val bundle = bundleOf(
                        "user_cal" to normCal,
                        "min_cal" to minCal,
                        "max_cal" to maxCal
                    )

                    it.findNavController()
                        .navigate(R.id.action_inputCal_to_calorie_calc, bundle)

                }
                    else {
                        Toast.makeText(activity, "Please, input required values.",
                            Toast.LENGTH_LONG).show()
                   }


        }


return binding.root

}



}