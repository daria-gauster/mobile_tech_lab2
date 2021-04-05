package com.example.android.lab2.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.android.lab2.R
import com.example.android.lab2.utilities.SharedViewModel
import kotlinx.android.synthetic.main.fragment_a.*
import java.io.IOException


class FragmentA : Fragment(R.layout.fragment_a) {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    fun loadFromAssets() {
        try {
            // get input stream
            tvBifido.background = Drawable.createFromStream(
                requireContext().assets.open(("bacteria/bifidobacterium.png")),
                null
            )
            tvLacto.background = Drawable.createFromStream(
                requireContext().assets.open(("bacteria/lactobacillus.jpg")),
                null
            )

        } catch (ex: IOException) {
            Log.d("FRAGMENTS", "UH OH")
            return
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loadFromAssets()
        tvBifido.setOnClickListener {
            sharedViewModel.saveBacteriaType("bifido")
        }
        tvLacto.setOnClickListener {
            sharedViewModel.saveBacteriaType("lacto")
        }
    }

}