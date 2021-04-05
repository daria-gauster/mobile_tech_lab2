package com.example.android.lab2.fragments

import android.os.Build
import android.os.Bundle
import android.text.Layout
import androidx.appcompat.app.AppCompatActivity
import com.example.android.lab2.R
import kotlinx.android.synthetic.main.activity_fragment_c.*
import kotlinx.android.synthetic.main.fragment_c.*

class FragmentCActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_c)


        /* i want to find a way to make it programmatically assign arrays based on passed bacteria type but idk how now */
        val bifidobacteria: Array<String> = resources.getStringArray(R.array.bifidobacteriaInfo)
        val lactobacteria: Array<String> = resources.getStringArray(R.array.lactobacteriaInfo)

        //justify text
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) tvBacteriaInfo.justificationMode =
            Layout.JUSTIFICATION_MODE_INTER_WORD

        val infoPos: Int = intent.getIntExtra("EXTRA_POSITION", 0)
        intent.extras
        when (intent.getStringExtra("EXTRA_TYPE")) {
            "bifido" -> tvBacteriaInfo.text = bifidobacteria[infoPos]
            "lacto" -> tvBacteriaInfo.text = lactobacteria[infoPos]
        }


    }
}