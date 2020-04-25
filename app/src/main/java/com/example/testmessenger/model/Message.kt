package com.example.testmessenger.model

import java.util.*

data class Message(
    val id: Long,

    var text: String,
    var date: Date,

    var author: Account
)