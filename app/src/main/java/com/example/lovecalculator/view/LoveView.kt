package com.example.lovecalculator.view

import com.example.lovecalculator.model.LoveModel

interface LoveView {

    fun navigationToResultScreen(loveModel: LoveModel)
    fun showError(error: String)

}