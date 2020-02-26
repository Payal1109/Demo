package com.example.allexercises.Activity_IntentPackage.ExplicitIntent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.allexercises.R
import kotlinx.android.synthetic.main.activity_second__explicit.*

class SecondActivity_Explicit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second__explicit)

        val bundle: Bundle? = intent.extras
        val msg = bundle!!.getString("my_msg")

        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()

        userMessage.text = msg
    }
}
