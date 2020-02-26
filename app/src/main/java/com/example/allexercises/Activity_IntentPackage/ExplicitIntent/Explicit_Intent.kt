package com.example.allexercises.Activity_IntentPackage.ExplicitIntent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.allexercises.R
import kotlinx.android.synthetic.main.activity_explicit__intent.*

class Explicit_Intent : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit__intent)

        btnShowToast.setOnClickListener {
            Log.i("Explicit_Intent", "Button clicked..")
            Toast.makeText(this,"Button clicked..", Toast.LENGTH_SHORT).show()
        }

        btn2.setOnClickListener{
            val message: String = etMessage.text.toString()

            val intent = Intent(this, SecondActivity_Explicit::class.java)

            intent.putExtra("my_msg",message)

            startActivity(intent)
        }
    }
}
