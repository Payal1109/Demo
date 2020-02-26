package com.example.allexercises.Activity_IntentPackage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.allexercises.*
import com.example.allexercises.Activity_IntentPackage.AutomaticNewActivity.AutoActivity
import com.example.allexercises.Activity_IntentPackage.EmailIntent.Email_Intent
import com.example.allexercises.Activity_IntentPackage.ExplicitIntent.Explicit_Intent
import com.example.allexercises.Activity_IntentPackage.ImplicitIntent.ImplicitIntent
import kotlinx.android.synthetic.main.activity__intent.*

class Activity_Intent : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__intent)

        auto.setOnClickListener {
            val intent = Intent(this, AutoActivity::class.java)
            startActivity(intent)
        }

        email.setOnClickListener {
            val intent = Intent(this, Email_Intent::class.java)
            startActivity(intent)
        }

        explicit.setOnClickListener {
            val intent = Intent(this, Explicit_Intent::class.java)
            startActivity(intent)
        }

        implicit.setOnClickListener {
            val intent = Intent(this, ImplicitIntent::class.java)
            startActivity(intent)
        }
    }
}
