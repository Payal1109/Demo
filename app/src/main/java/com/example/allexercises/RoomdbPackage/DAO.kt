package com.example.allexercises.RoomdbPackage

import androidx.room.*

@Dao
interface DAO
{
    @Insert
    fun saveEmp(emp : Entity)

    @Query("select * from Entity")
    fun readData() : List<Entity>

    @Delete
    fun delData(emp: Entity)

    @Update
    fun updateData(emp: Entity)

}