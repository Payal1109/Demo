package com.example.allexercises.FormPackage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.allexercises.R
import kotlinx.android.synthetic.main.activity_next.*

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        val bundle: Bundle?=intent.extras
        val string = bundle!!.getString("my_msg")
        Msg.text = string
    }
}
