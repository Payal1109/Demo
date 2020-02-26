package com.example.allexercises.FormPackage

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.widget.Toolbar
import com.example.allexercises.R
import kotlinx.android.synthetic.main.activity_my_form.*
import kotlinx.android.synthetic.main.customtoast.*
import java.util.*

class MyForm : AppCompatActivity() {

    lateinit var option: Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_form)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        option = findViewById(R.id.spn) as Spinner

        val options = arrayOf("Btech", "Mtech", "BBA", "MBA")
        option.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)


        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                options.get(position)
            }

        }
        val toggle: ToggleButton = findViewById(R.id.togglebtn)
        toggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                toggle.setOnClickListener {
                    val message: String = "Your Record Submitted Successfully & You are signed in."

                    val intent = Intent(this, NextActivity::class.java)
                    intent.putExtra("my_msg", message)
                    startActivity(intent)

                }

            } else {
                toggle.setOnClickListener {
                    val message: String = "You are not signed in."

                    val intent = Intent(this, NextActivity::class.java)
                    intent.putExtra("my_msg", message)
                    startActivity(intent)

                }
            }
        }

        val layout = layoutInflater.inflate(R.layout.customtoast, relativeLayout)
        fab_btn.setOnClickListener() {

            val myToast = Toast(applicationContext)
            myToast.duration = Toast.LENGTH_LONG
            myToast.setGravity(Gravity.BOTTOM, 0, 0)
            myToast.view = layout
            myToast.show()
            finish()
            startActivity(getIntent())
        }

    }


    fun clickDatePicker(view: View) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val date = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->


            etTxt3.setText("$dayOfMonth/${monthOfYear+1}/$year")
        }, year, month, day)
        date.show() }
}

