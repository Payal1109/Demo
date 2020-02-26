package com.example.allexercises.Coordinator_Nav_TxtInput.Coordinator_Snackbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.allexercises.R
import com.google.android.material.snackbar.Snackbar

class CoordinatorLayout : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_layout)

        val button: Button =findViewById(R.id.btn)
        val myLayout: CoordinatorLayout =findViewById(R.id.layout)

        button.setOnClickListener{
            Snackbar.make(myLayout,"Button clicked", Snackbar.LENGTH_SHORT).show()
        }
    }
}
