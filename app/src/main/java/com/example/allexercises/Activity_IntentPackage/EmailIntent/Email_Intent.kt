package com.example.allexercises.Activity_IntentPackage.EmailIntent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.allexercises.R
import kotlinx.android.synthetic.main.activity_email__intent.*
import java.lang.Exception

class Email_Intent : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email__intent)

        sendEmailBtn.setOnClickListener(){

            val recipient = recipientEt.text.toString().trim()
            val subject = subjectEt.text.toString().trim()
            val message = messageEt.text.toString().trim()

            sendEmail(recipient,subject,message)
        }
    }

    private fun sendEmail(recipient: String, subject: String, message: String){

        val mIntent = Intent(Intent.ACTION_SEND)

        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"

        mIntent.putExtra(Intent.EXTRA_EMAIL,arrayOf(recipient))
        mIntent.putExtra(Intent.EXTRA_SUBJECT,subject)
        mIntent.putExtra(Intent.EXTRA_TEXT,message)

        try {

            startActivity(Intent.createChooser(mIntent,"Choose Email Receiver"))

        }
        catch (e: Exception){

            Toast.makeText(this,e.message, Toast.LENGTH_LONG).show()
        }
    }
}



