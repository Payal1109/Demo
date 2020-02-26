package com.example.allexercises.Coordinator_Nav_TxtInput.TextInputLayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.Toast
import com.example.allexercises.R
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_text_input_layout.*

class TextInputLayout : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_input_layout)

        val etConfirmPassword=findViewById<TextInputEditText>(R.id.confirmPassword)
        val etUsername = findViewById<TextInputEditText>(R.id.username)
        val etPassword = findViewById<TextInputEditText>(R.id.password)
        val submit = findViewById<Button>(R.id.submit)


        username.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(s: Editable) {
                if (s.length > layoutName.getCounterMaxLength())
                    layoutName.error = "Max character length is " + layoutName.counterMaxLength
                else
                    layoutName.error = null
            }
        })

        submit.setOnClickListener {
            val username = etUsername.text.toString()
            val password=etPassword.text.toString()
            val confirmPassword=etConfirmPassword.text.toString()
            if (password==confirmPassword){
                Toast.makeText(this,"Welcome $username!!!..You Log in Successfully", Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(this,"Password is not match", Toast.LENGTH_SHORT).show()
            }
        }


    }
}
