package com.example.allexercises.RoomdbPackage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.allexercises.R
import androidx.room.Room

class RoomDatabase : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_database)

        var db = Room.databaseBuilder(applicationContext,DataBase::class.java,"EmpDB").fallbackToDestructiveMigration().build()

        Thread{
            var emp = Entity()
            emp.emp_id = 1
            emp.emp_name = "Payal"
            emp.emp_post = "Android Developer"

            emp.emp_id = 2
            emp.emp_name = "Nilisha"
            emp.emp_post = "ios Developer"


            db.empDAO().saveEmp(emp)

            // db.empDAO().delData(emp)

            // db.empDAO() .updateData(emp)

            db.empDAO().readData().forEach{
                Log.i("@Payal","Id is : ${it.emp_id}")
                Log.i("@Payal","Name is : ${it.emp_name}")
                Log.i("@Payal","Post is : ${it.emp_post}")
            }

        }.start()
    }
}



