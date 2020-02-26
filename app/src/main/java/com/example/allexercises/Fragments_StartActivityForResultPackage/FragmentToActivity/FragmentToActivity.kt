package com.example.allexercises.Fragments_StartActivityForResultPackage.FragmentToActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.allexercises.R

class FragmentToActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_to)

        val manager = supportFragmentManager
        val t = manager.beginTransaction()
        val b =
            BlankFragment()
        t.add(R.id.linear, b)
        t.commit()
    }
    fun f1(s1: String, s2: String) {

        val t1 : TextView = findViewById(R.id.txt1)
        val t2 : TextView = findViewById(R.id.txt2)
        t1.text = s1
        t2.text = s2
    }

}
