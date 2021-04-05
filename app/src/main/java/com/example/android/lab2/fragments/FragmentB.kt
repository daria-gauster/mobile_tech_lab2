package com.example.android.lab2.fragments

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import com.example.android.lab2.R
import com.example.android.lab2.utilities.SharedViewModel
import kotlinx.android.synthetic.main.fragment_b.*


class FragmentB : Fragment(R.layout.fragment_b) {
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val bifidobacteria: Array<String> = resources.getStringArray(R.array.bifidobacteria)
        val lactobacteria: Array<String> = resources.getStringArray(R.array.lactobacteria)

        sharedViewModel.bacteria.observe(viewLifecycleOwner) { bacteria ->
            when (bacteria) {
                "bifido" -> fillBacteriaList(bifidobacteria, bacteria)
                "lacto" -> fillBacteriaList(lactobacteria, bacteria)
            }
        }
        sharedViewModel.bacteriaSpp.observe(viewLifecycleOwner) { bacteriaSpp ->
            if (Configuration.ORIENTATION_PORTRAIT == this.resources.configuration.orientation) {
                startIntent(sharedViewModel.bacteria.value!!, bacteriaSpp, view)
            }
        }

    }

    private fun fillBacteriaList(bacteria: Array<String>, bacteriaType: String = "bifido") {
        val arrayAdapter = ArrayAdapter<String>(
            this.requireContext(),
            android.R.layout.simple_list_item_1,
            bacteria
        )
        lvBacteria.adapter = arrayAdapter

        lvBacteria.setOnItemClickListener { parent, view, position, id ->
            sharedViewModel.saveBacteriaSpp(position)
        }
    }

    private fun startIntent(bacteriaType: String, position: Int, view: View) {
        val intent = Intent(view.context, FragmentCActivity::class.java)
        intent.putExtra("EXTRA_TYPE", bacteriaType)
        intent.putExtra("EXTRA_POSITION", position)
        startActivity(intent)
    }

}
