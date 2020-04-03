package com.example.testmessenger.adapter

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testmessenger.Contact
import com.example.testmessenger.R
import com.example.testmessenger.utils.inflate

class ContactListAdapter(private val listMessages: List<Contact>,
                         private val listener: (Contact) -> Unit) : RecyclerView.Adapter<ContactListAdapter.MessageViewHolder>() {

    override fun getItemCount(): Int = listMessages.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MessageViewHolder(parent.inflate(
        R.layout.item_contact_message))

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        return holder.bind(listMessages[position], listener)
    }

    // Local classes
    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(contact: Contact, listener: (Contact) -> Unit) = with(itemView){
            val textView: AppCompatTextView = findViewById(R.id.tvUserLastMessage)
            textView.text = contact.lastMessage

            val iconView: AppCompatImageView = findViewById(R.id.ivUserIcon)
            iconView.setImageBitmap(contact.userIcon)

            setOnClickListener{listener(contact)}
        }
    }
}