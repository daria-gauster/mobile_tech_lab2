package com.example.android.lab2.ui.actors

import java.io.Serializable

data class Actor(
        val id: Int,
        val name: String,
        val dateOfBirth: String,
        val movie: String,
        val height: String,
        val quote: String
) : Serializable