package com.example.android.lab2.ui.actors

import android.os.Build
import android.os.Bundle
import android.text.Layout.JUSTIFICATION_MODE_INTER_WORD
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.android.lab2.R
import kotlinx.android.synthetic.main.activity_actor.*

class ActorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actor)

        //justify text
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) tvActorActivityQuote.justificationMode =
            JUSTIFICATION_MODE_INTER_WORD


        val actor = intent.getSerializableExtra("EXTRA_ACTOR") as Actor
        initialize(actor)

        //finish the activity
        btnActorActivityBackToMain.setOnClickListener { finish() }
    }

    //fill the views with chosen actor data
    private fun initialize(actor: Actor) {
        ivActorActivityPortait.setImageResource(
            resources.getIdentifier(
                "pic_${actor.id}",
                "drawable",
                packageName
            )
        )
        tvActorActivityName.text = actor.name
        tvActorActivityDateOfBirth.text = "Born on ${actor.dateOfBirth}"
        tvActorActivityMovie.text = "Known for movie \"${actor.movie}\""
        tvActorActivityHeight.text = "Height: ${actor.height}"
        tvActorActivityQuote.text = "Personal quote:\n${actor.quote}"
        Log.d("ACTOR_ACTIVITY", "$actor")
    }

}