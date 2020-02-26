package com.example.allexercises.RoomdbPackage

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [(Entity::class)],version = 8)//EveryTime Update The Version Before Run The App
abstract class DataBase : RoomDatabase()
{
    abstract fun empDAO() : DAO
}