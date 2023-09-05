package com.example.lovecalculator.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lovecalculator.ResultPresenter
import com.example.lovecalculator.changeScreen
import com.example.lovecalculator.databinding.ActivitySecondBinding
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.view.ResultView


class SecondActivity : AppCompatActivity(),ResultView {
    private lateinit var binding: ActivitySecondBinding
    private val resultPresenter = ResultPresenter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
        setupUI()
    }

    private fun initClickers() {
        with(binding) {
            historyImb.setOnClickListener {
                val intent = Intent(this@SecondActivity, HistoryActivity::class.java)
                startActivity(intent)
               // changeScreen(HistoryActivity(), null)
            }

             tryBtn.setOnClickListener {
                val intent = Intent(this@SecondActivity, MainActivity::class.java)
                //intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
            }
        }
    }



    private fun setupUI() {
        val result = intent.getSerializableExtra("key") as LoveModel

            resultPresenter.getData(result)
        }

    override fun showLove(fname: String, sname: String, percentage: String, result: String) {
        with(binding){
            fnameTV.text = fname
            snameTV.text = sname
            percentageTV.text = percentage
            resultTV.text = result

        }
    }
}