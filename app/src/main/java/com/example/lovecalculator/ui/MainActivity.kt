package com.example.lovecalculator.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.lovecalculator.App
import com.example.lovecalculator.Presenter
import com.example.lovecalculator.changeScreen
import com.example.lovecalculator.databinding.ActivityMainBinding
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.view.LoveView


class MainActivity : AppCompatActivity(),LoveView {
    lateinit var binding: ActivityMainBinding
    private val presenter = Presenter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            calculateBtn.setOnClickListener {
                presenter.getLoveResult(firstEd.text.toString(), secondEd.text.toString())
            }
        }
    }

    override fun navigationToResultScreen(loveModel: LoveModel) {
        App.appDatabase.loveDao().insert(loveModel)
        changeScreen(SecondActivity(), loveModel)

    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
}

