package com.example.allexercises.RecyclerViewPackage

import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.allexercises.R
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlinx.android.synthetic.main.contact_child.view.*

class RecyclerView : AppCompatActivity() {

    val READ_CONTACTS_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        contact_list.layoutManager = LinearLayoutManager(this)

        btn.setOnClickListener {

            if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_CONTACTS),READ_CONTACTS_REQUEST_CODE)
            }
            else
            {
                val contactList : MutableList<contactDTO> = ArrayList()
                val contacts = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null)!!
                while (contacts.moveToNext()){
                    val name = contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                    val number = contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                    val obj = contactDTO()
                    obj.name = name
                    obj.number = number

                    contactList.add(obj)
                }
                contact_list.adapter = ContactAdapter(contactList,this)
                contacts.close()
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            READ_CONTACTS_REQUEST_CODE -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {

                    val contactList : MutableList<contactDTO> = ArrayList()
                    val contacts = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null)!!
                    while (contacts.moveToNext()){
                        val name = contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                        val number = contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                        val obj = contactDTO()
                        obj.name = name
                        obj.number = number

                        contactList.add(obj)
                    }
                    contact_list.adapter = ContactAdapter(contactList,this)
                    contacts.close()

                } else if (grantResults[0] == PackageManager.PERMISSION_DENIED){
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this,android.Manifest.permission.READ_CONTACTS)){
                        val dialog: AlertDialog.Builder = AlertDialog.Builder(this)
                        dialog.setTitle("Important Permission Required..")
                        dialog.setMessage("This Permission is important to access contacts to see the list of contacts in phone.")
                        dialog.show()
                    }

                }
                return
            }


        }

    }

    class ContactAdapter(items: List<contactDTO>, ctx: Context) :
        RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

        private var list: List<contactDTO> = items
        private var context: Context = ctx

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ContactAdapter.ViewHolder, position: Int) {
            holder.name.text = list[position].name
            holder.number.text = list[position].number
            holder.profile.setImageDrawable(ContextCompat.getDrawable(context,R.mipmap.ic_launcher_round))
        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ContactAdapter.ViewHolder {
            return ViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.contact_child,
                    parent,
                    false
                )
            )
        }

        class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
            val name: TextView = v.tv_name!!
            val number: TextView = v.tv_number!!
            val profile: ImageView = v.iv_profile!!
        }

    }
}
