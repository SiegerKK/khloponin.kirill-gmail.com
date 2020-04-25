package com.example.testmessenger.model

class Conversation(
    val id: Long,

    var members: ArrayList<Account>,
    var messages: ArrayList<Message>
){
    fun getLastMessage(): Message = messages[messages.size - 1]
}