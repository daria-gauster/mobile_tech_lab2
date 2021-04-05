package com.example.android.lab2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.lab2.R
import com.example.android.lab2.fragments.FragmentA
import com.example.android.lab2.fragments.FragmentB
import com.example.android.lab2.fragments.FragmentC
import kotlinx.android.synthetic.main.activity_fragments.*


class FragmentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments)

        if (null != layout_portrait) {
            supportFragmentManager.beginTransaction().apply {
                val fragmentA = FragmentA()
                val fragmentB = FragmentB()
                replace(R.id.flFragmentA, fragmentA)
                replace(R.id.flFragmentB, fragmentB)
                commit()
            }
        } else {
            supportFragmentManager.beginTransaction().apply {
                val fragmentA =
                    FragmentA()
                val fragmentB =
                    FragmentB()
                val fragmentC =
                    FragmentC()
                replace(R.id.flFragmentA, fragmentA)
                replace(R.id.flFragmentB, fragmentB)
                replace(R.id.flFragmentC, fragmentC)
                commit()
            }


        }

    }

}