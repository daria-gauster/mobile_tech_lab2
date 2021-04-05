package com.example.android.lab2.fragments

import android.os.Build
import android.os.Bundle
import android.text.Layout
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import com.example.android.lab2.R
import com.example.android.lab2.utilities.SharedViewModel
import kotlinx.android.synthetic.main.activity_actor.*
import kotlinx.android.synthetic.main.activity_fragment_c.*
import kotlinx.android.synthetic.main.activity_fragments.*
import kotlinx.android.synthetic.main.fragment_c.*


class FragmentC : Fragment(R.layout.fragment_c) {
    private val sharedViewModel: SharedViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bifidobacteria: Array<String> = resources.getStringArray(R.array.bifidobacteriaInfo)
        val lactobacteria: Array<String> = resources.getStringArray(R.array.lactobacteriaInfo)

        //justify text
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) tvFragmentC.justificationMode =
            Layout.JUSTIFICATION_MODE_INTER_WORD

        sharedViewModel.bacteriaSpp.observe(viewLifecycleOwner) { bacteriaSpp ->
            if (null == layout_portrait) {
                tvFragmentC.text =
                    if (sharedViewModel.bacteria.value == "lacto") lactobacteria[bacteriaSpp] else bifidobacteria[bacteriaSpp]
            }
        }
    }

}