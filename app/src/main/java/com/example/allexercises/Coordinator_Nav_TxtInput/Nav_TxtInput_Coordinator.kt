package com.example.allexercises.Coordinator_Nav_TxtInput

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.allexercises.Coordinator_Nav_TxtInput.Coordinator_Snackbar.CoordinatorLayout
import com.example.allexercises.Coordinator_Nav_TxtInput.NavigationView.NavigationView
import com.example.allexercises.R
import com.example.allexercises.Coordinator_Nav_TxtInput.TextInputLayout.TextInputLayout
import kotlinx.android.synthetic.main.activity_nav__txt_input__coordinator.*

class Nav_TxtInput_Coordinator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav__txt_input__coordinator)

        snackbar.setOnClickListener {
            val intent = Intent(this, CoordinatorLayout::class.java)
            startActivity(intent)
        }

        navigation.setOnClickListener {
            val intent = Intent(this, NavigationView::class.java)
            startActivity(intent)
        }

        txtInput.setOnClickListener {
            val intent = Intent(this, TextInputLayout::class.java)
            startActivity(intent)
        }
    }
}
