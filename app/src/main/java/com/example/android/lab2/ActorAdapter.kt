package com.example.android.lab2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.lab2.ui.actors.Actor
import com.example.android.lab2.ui.actors.ActorActivity
import kotlinx.android.synthetic.main.item_actor.view.*

class ActorAdapter(
    private var actors: List<Actor>
) : RecyclerView.Adapter<ActorAdapter.ViewHolder>() {

    inner class ViewHolder(actorView: View) : RecyclerView.ViewHolder(actorView) {
        //bind the data to the card view
        fun bind(actor: Actor) {
            itemView.apply {
                val resourceId = context.resources.getIdentifier(
                    ("pic_${actor.id}"), "drawable",
                    context.packageName
                )
                ivFace.apply {
                    setImageDrawable(resources.getDrawable(resourceId))
                    setOnClickListener {
                        it.animate().apply {
                            duration = 1000
                            rotationYBy(360f)
                        }.start()
                    }
                }

                tvName.text = actor.name
                tvDateOfBirth.text = actor.dateOfBirth
                tvMovie.text = actor.movie
                setOnClickListener {
                    Intent(context, ActorActivity::class.java).also {
                        it.putExtra("EXTRA_ACTOR", actor)
                        context.startActivity(it)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val actorView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_actor, parent, false)
        return ViewHolder(actorView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(actors[position])
    }

    override fun getItemCount() = actors.size
}

