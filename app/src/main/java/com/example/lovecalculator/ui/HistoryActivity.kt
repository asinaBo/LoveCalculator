package com.example.lovecalculator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lovecalculator.App
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {
    lateinit var binding:ActivityHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()

    }

    private fun setupUI() {
        //vytashili list
        var list = App.appDatabase.loveDao().getAll()
        list.forEach{
            binding.historyTv.append(
                "${it.firstName}\n ${it.secondName} \n ${it.percentage}\n ${it.result}\n-------\n")
        }


    }
}