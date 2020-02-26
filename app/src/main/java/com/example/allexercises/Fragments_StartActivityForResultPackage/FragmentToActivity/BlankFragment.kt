package com.example.allexercises.Fragments_StartActivityForResultPackage.FragmentToActivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.allexercises.R

class BlankFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_blank, container, false)

        val e1 = v.findViewById<View>(R.id.editTxt1) as EditText
        val e2 = v.findViewById<View>(R.id.editTxt2) as EditText
        val b1 = v.findViewById<View>(R.id.btn1) as Button
        b1.setOnClickListener {
            val fName = e1.text.toString()
            val pName = e2.text.toString()
            val m1 = activity as FragmentToActivity?
            m1!!.f1(fName, pName)
        }
        return v
    }

}