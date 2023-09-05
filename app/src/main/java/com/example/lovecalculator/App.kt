package com.example.lovecalculator

import android.app.Application
import androidx.room.Room
import com.example.lovecalculator.model.room.AppDataBase

class App: Application() {

    companion object{
        lateinit var appDatabase: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()

        appDatabase = Room.databaseBuilder(applicationContext,AppDataBase::class.java, "love-file")
            .allowMainThreadQueries()// NADO SPROSIT DLYA CHEGO ETO
            .build()
    }
}