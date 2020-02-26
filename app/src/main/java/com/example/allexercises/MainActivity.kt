package com.example.allexercises

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.allexercises.Activity_IntentPackage.Activity_Intent
import com.example.allexercises.Coordinator_Nav_TxtInput.Nav_TxtInput_Coordinator
import com.example.allexercises.FormPackage.MyForm
import com.example.allexercises.Fragments_StartActivityForResultPackage.Fragment_StartActivityForResult
import com.example.allexercises.LayoutsPackage.Layouts
import com.example.allexercises.RecyclerViewPackage.RecyclerView
import com.example.allexercises.RoomdbPackage.RoomDatabase
import com.example.allexercises.RuntimePermission.Runtime_Permission_add_contact
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        activity.setOnClickListener {
            val intent = Intent(this, Activity_Intent::class.java)
            startActivity(intent)
        }
        fragment.setOnClickListener {
            val intent = Intent(this, Fragment_StartActivityForResult::class.java)
            startActivity(intent)
        }

        layouts.setOnClickListener {

            val intent = Intent(this, Layouts::class.java)
            startActivity(intent)
        }

        form.setOnClickListener {
            val intent = Intent(this, MyForm::class.java)
            startActivity(intent)
        }

        nav.setOnClickListener {
            val intent = Intent(this, Nav_TxtInput_Coordinator::class.java)
            startActivity(intent)
        }

        recycler.setOnClickListener {
            val intent = Intent(this, RecyclerView::class.java)
            startActivity(intent)
        }

        roomdb.setOnClickListener {
            val intent = Intent(this, RoomDatabase::class.java)
            startActivity(intent)
        }

        runtimepermission.setOnClickListener {
            val intent = Intent(this, Runtime_Permission_add_contact::class.java)
            startActivity(intent)
        }

    }
}
