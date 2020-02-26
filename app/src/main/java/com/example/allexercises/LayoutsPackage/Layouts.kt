package com.example.allexercises.LayoutsPackage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.allexercises.LayoutsPackage.ConstraintLayout.Constraint
import com.example.allexercises.LayoutsPackage.LinearLayout.Linear
import com.example.allexercises.R
import com.example.allexercises.LayoutsPackage.RelativeLayout.Relative
import com.example.allexercises.LayoutsPackage.WebView.Web_View
import kotlinx.android.synthetic.main.activity_layouts.*

class Layouts : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layouts)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        linear.setOnClickListener {

            val intent = Intent(this, Linear::class.java)
            startActivity(intent)
        }

        relative.setOnClickListener {
            val intent = Intent(this, Relative::class.java)
            startActivity(intent)
        }

        constraint.setOnClickListener {
            val intent = Intent(this, Constraint::class.java)
            startActivity(intent)
        }

        web.setOnClickListener {
            val intent = Intent(this, Web_View::class.java)
            startActivity(intent)
        }

    }
}
