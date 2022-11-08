package com.example.fitness_calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitness_calc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding //for binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //for binding
        setContentView(binding.root) //for binding
    }
}