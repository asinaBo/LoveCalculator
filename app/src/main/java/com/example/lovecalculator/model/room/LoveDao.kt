package com.example.lovecalculator.model.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecalculator.model.LoveModel


@Dao
interface LoveDao {
    @Insert
    fun insert(loveModel: LoveModel) //to add all model datas

@Query("SELECT * FROM love_table  ORDER BY id DESC")//latest on first line
    fun getAll():List<LoveModel>  // list because there a lot history in designe

}