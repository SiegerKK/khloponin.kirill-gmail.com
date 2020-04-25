package com.example.testmessenger.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testmessenger.R
import com.example.testmessenger.adapter.ContactListAdapter
import com.example.testmessenger.model.Account
import com.example.testmessenger.model.Conversation
import com.example.testmessenger.model.Message
import java.util.*
import kotlin.collections.ArrayList

const val INTENT_MESSAGE = "com.example.testmessenger.LAST_MESSAGE"
val conversations: ArrayList<Conversation> = ArrayList()
val accounts: ArrayList<Account> = ArrayList()

class MainActivity : AppCompatActivity() {
    private lateinit var rvContactList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        accounts.add(Account(1, "John Doe1"))
        accounts.add(Account(2, "John Doe2"))
        accounts.add(Account(3, "John Doe3"))
        for (i in 1..2){
            val conversation: Conversation = Conversation(i.toLong(), ArrayList(), ArrayList())
            conversation.members.add(accounts[0])
            conversation.members.add(accounts[i])
            for (j in 0..10)
                conversation.messages.add(Message(j.toLong(), "Test$j", Date(10000000L + j * 100000), conversation.members[j % 2]))
            conversations.add(conversation)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvContactList = findViewById(R.id.rvContacts)
        rvContactList.layoutManager = LinearLayoutManager(this)
        rvContactList.adapter = ContactListAdapter(conversations) {
            val intent = Intent(this, ConversationActivity::class.java)
            intent.putExtra(INTENT_MESSAGE, it.id)
            startActivity(intent)
        }
    }
}
