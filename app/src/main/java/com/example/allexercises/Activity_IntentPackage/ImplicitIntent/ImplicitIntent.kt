package com.example.allexercises.Activity_IntentPackage.ImplicitIntent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import com.example.allexercises.R
import kotlinx.android.synthetic.main.activity_implicit_intent.*

class ImplicitIntent : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)
    }
    public fun process(v: View)
    {
        if (v.getId()== R.id.LaunchMap) {
            var intent: Intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("geo:19.048.72.8747"))
            var chooser: Intent = Intent.createChooser(intent, "Launch Maps")
            startActivity(chooser)
        }
        if (v.getId()== R.id.LaunchMarket) {
            var intent: Intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("market://details?id=dolphin.developers.com"))
            var chooser: Intent = Intent.createChooser(intent, "Launch Market")
            startActivity(chooser)
        }
        if (v.getId()== R.id.sendEmail) {
            var intent: Intent = Intent(Intent.ACTION_SEND)
            intent.setData(Uri.parse("mailto:"))
            var to = arrayOf("rajputpayal1999@gmail.com","payal.r@simformsolutions.com")
            intent.putExtra(Intent.EXTRA_EMAIL,to)
            intent.putExtra(Intent.EXTRA_SUBJECT,"This is the sample msg..")
            intent.putExtra(Intent.EXTRA_TEXT,"Hii...What's goig on? How r u?")
            intent.setType("text/plain")
            var chooser: Intent = Intent.createChooser(intent, "Send Email")
            startActivity(chooser)
        }
        if (v.getId()== R.id.sendImage) {
            var imgUri = intent.setData(Uri.parse("android.resource://slidenerd.vivz/drawable/"+ R.drawable.ic_launcher_foreground))
            var intent: Intent = Intent(Intent.ACTION_SEND)
            intent.setType("image/*")
            intent.putExtra(Intent.EXTRA_STREAM,imgUri)
            var chooser: Intent = Intent.createChooser(intent, "Send Image")
            startActivity(chooser)
        }
        if (v.getId()== R.id.dialCall) {
            var intent: Intent = Intent(Intent.ACTION_CALL)
            intent.setData(Uri.parse("tel:"+dialCall.getText()))
            var chooser: Intent = Intent.createChooser(intent, "Telephone")
            startActivity(chooser)
        }
        if (v.getId()== R.id.contacts) {
            var intent: Intent = Intent(Intent.ACTION_PICK)
            intent.type = ContactsContract.Contacts.CONTENT_TYPE
            startActivity(intent)
        }

    }
}
