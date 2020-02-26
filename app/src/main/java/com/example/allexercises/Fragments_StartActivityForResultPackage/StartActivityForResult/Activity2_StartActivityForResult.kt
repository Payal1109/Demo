package com.example.allexercises.Fragments_StartActivityForResultPackage.StartActivityForResult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.allexercises.R
import kotlinx.android.synthetic.main.activity_activity2__start_for_result.*

class Activity2_StartActivityForResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity2__start_for_result)

        val bundle:Bundle?=intent.extras
        val string = bundle!!.getString("msg")
        textView1.text=string

    }

    fun  buttonClick2(view: View) {


        val editText = findViewById(R.id.editText) as EditText
        val stringToPassBack = editText.text.toString()


        val intent = Intent()
        intent.putExtra("keyName", stringToPassBack)
        setResult(Activity.RESULT_OK, intent)
        finish()

    }
}
