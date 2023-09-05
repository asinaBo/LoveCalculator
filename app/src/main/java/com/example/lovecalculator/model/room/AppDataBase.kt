package com.example.lovecalculator.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lovecalculator.model.LoveModel


@Database(entities = [LoveModel::class], version = 1)


abstract class AppDataBase: RoomDatabase() {

    abstract  fun loveDao (): LoveDao // we return spisok


}