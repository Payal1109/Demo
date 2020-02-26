package com.example.allexercises.Fragments_StartActivityForResultPackage.StartActivityForResult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.allexercises.R
import kotlinx.android.synthetic.main.activity_start_for_result.*

class StartActivityForResult : AppCompatActivity() {

    private val SECOND_ACTIVITY_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_for_result)
    }
    fun buttonClick1(view: View) {
        val message:String = etText.text.toString()
        val intent = Intent(this, Activity2_StartActivityForResult::class.java)
        intent.putExtra("msg",message)
        startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {

                val returnString = data!!.getStringExtra("keyName")
                val textView = findViewById(R.id.textView) as TextView
                textView.text = returnString
            }
        }
    }
}
