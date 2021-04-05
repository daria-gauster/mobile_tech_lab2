package com.example.android.lab2.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.lab2.ActorAdapter
import com.example.android.lab2.R
import com.example.android.lab2.ui.actors.Actor
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    // Registering the Kotlin module with the ObjectMpper instance
    private val mapper = jacksonObjectMapper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // JSON String
        var userListFromJson: List<Actor> = mapper.readValue(loadJSONFromAsset().trimIndent())

        //recylerview adapter
        val adapter = ActorAdapter(userListFromJson)
        rvActors.adapter = adapter
        rvActors.layoutManager = LinearLayoutManager(this)

        btnToLab2.setOnClickListener {
            Intent(this, FragmentsActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    //load actors data to a jsonstring
    private fun loadJSONFromAsset(): String {
        var jsonString: String
        try {
            val input: InputStream = assets.open("actors.json")
            val size: Int = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            jsonString = String(buffer)
            input.close()
        } catch (ex: IOException) {
            ex.printStackTrace()
            return "null"
        }
        return jsonString
    }
}