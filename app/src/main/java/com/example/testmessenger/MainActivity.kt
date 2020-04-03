package com.example.testmessenger

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testmessenger.adapter.ContactListAdapter

const val INTENT_MESSAGE = "com.example.testmessenger.MESSAGE"

class MainActivity : AppCompatActivity() {
    lateinit var listMessages: ArrayList<Contact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val icon = BitmapFactory.decodeResource(
            resources,
            R.mipmap.ic_launcher
        )

        listMessages = ArrayList();
        listMessages.add(Contact("XYU1", icon))
        listMessages.add(Contact("XYU2", icon))
        listMessages.add(Contact("XYU3", icon))
        listMessages.add(Contact("XYU4", icon))

        val contactMessagesList: RecyclerView = findViewById(R.id.recyclerViewContactMessages)
        contactMessagesList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        contactMessagesList.adapter = ContactListAdapter(listMessages){
            val intent = Intent()
            intent.putExtra(INTENT_MESSAGE, it.lastMessage)
//            startActivity(intent)
        }
    }
}
