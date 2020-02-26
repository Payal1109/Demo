package com.example.allexercises.RuntimePermission

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.allexercises.R

class Runtime_Permission_add_contact : AppCompatActivity() {

    val WRITE_CONTACTS_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_runtime__permission_add_contact)

        val button: Button =findViewById(R.id.btn)

        button.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.WRITE_CONTACTS) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_CONTACTS),WRITE_CONTACTS_REQUEST_CODE)
            }
            else
            {
                val intent: Intent = Intent(ContactsContract.Intents.Insert.ACTION)
                intent.setType(ContactsContract.RawContacts.CONTENT_TYPE)
                startActivity(intent)
            }
        }

    }
    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            WRITE_CONTACTS_REQUEST_CODE -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {

                    val intent: Intent = Intent(ContactsContract.Intents.Insert.ACTION)
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE)
                    startActivity(intent)

                } else if (grantResults[0] == PackageManager.PERMISSION_DENIED){
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this,android.Manifest.permission.WRITE_CONTACTS)){
                        val dialog: AlertDialog.Builder = AlertDialog.Builder(this)
                        dialog.setTitle("Important Permission Required..")
                        dialog.setMessage("This Permission is important to access contacts and to add a new contact to the phone. Please permit this permission.")
                        dialog.show()
                    }

                }
                return
            }


        }

    }
}
