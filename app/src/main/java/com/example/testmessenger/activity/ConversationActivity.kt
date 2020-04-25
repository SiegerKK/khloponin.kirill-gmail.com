package com.example.testmessenger.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testmessenger.R
import com.example.testmessenger.adapter.ContactListAdapter
import com.example.testmessenger.adapter.MessageListAdapter

class ConversationActivity : AppCompatActivity() {
    private lateinit var rvMessages: RecyclerView
    private lateinit var etInputMessage: EditText
    private lateinit var bSendMessage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation)

        rvMessages = findViewById(R.id.rvMessages)
        etInputMessage = findViewById(R.id.etInputMessage)
        bSendMessage = findViewById(R.id.bSendMessage)

        rvMessages.layoutManager = LinearLayoutManager(this)

        val id = intent.getLongExtra(INTENT_MESSAGE, 0)
        rvMessages.adapter = MessageListAdapter(conversations[conversations.indexOfFirst { it.id == id }].messages) {}
    }
}