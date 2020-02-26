package com.example.allexercises.Fragments_StartActivityForResultPackage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.allexercises.Fragments_StartActivityForResultPackage.FragmentToActivity.FragmentToActivity
import com.example.allexercises.Fragments_StartActivityForResultPackage.MultipleFragments.MultipleFragments
import com.example.allexercises.R
import com.example.allexercises.Fragments_StartActivityForResultPackage.StartActivityForResult.StartActivityForResult
import kotlinx.android.synthetic.main.activity_fragment__start_for_result.*

class Fragment_StartActivityForResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment__start_for_result)

        fragtoactivity.setOnClickListener {
            val intent = Intent(this, FragmentToActivity::class.java)
            startActivity(intent)
        }

        mulfrag.setOnClickListener {
            val intent = Intent(this, MultipleFragments::class.java)
            startActivity(intent)
        }

        forresult.setOnClickListener {
            val intent = Intent(this, StartActivityForResult::class.java)
            startActivity(intent)
        }
    }
}
