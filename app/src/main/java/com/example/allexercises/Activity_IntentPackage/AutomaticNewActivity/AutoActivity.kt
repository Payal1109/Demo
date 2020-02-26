package com.example.allexercises.Activity_IntentPackage.AutomaticNewActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.allexercises.R
import java.util.*

class AutoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto)

        var timer: Timer
        timer = Timer()
        timer.schedule(object : TimerTask(){
            override fun run() {
                val intent = Intent(this@AutoActivity,
                    NewActivity_Automatic::class.java)
                startActivity(intent)
                finish()
            }
        },3000)
    }
}
