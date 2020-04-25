package com.example.testmessenger.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testmessenger.R
import com.example.testmessenger.model.Conversation
import com.example.testmessenger.utils.inflate

class ContactListAdapter(private val dialogs: List<Conversation>,
                         private val listener: (Conversation) -> Unit) : RecyclerView.Adapter<ContactListAdapter.ConversationViewHolder>() {

    override fun getItemCount(): Int = dialogs.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ConversationViewHolder(parent.inflate(R.layout.item_contact_message))
    override fun onBindViewHolder(holder: ConversationViewHolder, position: Int) = holder.bind(dialogs[position], listener)

    //-----------------------Local classes-----------------------//
    class ConversationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(conversation: Conversation, listener: (Conversation) -> Unit) = with(itemView){
            val imageViewIcon: ImageView = findViewById(R.id.ivUserIcon)
            val textViewText: AppCompatTextView = findViewById(R.id.tvUserMessage)
            val textViewTime: AppCompatTextView = findViewById(R.id.tvUserMessageTime)
            textViewText.text = conversation.getLastMessage().text
            textViewTime.text = conversation.getLastMessage().date.toString()
            setOnClickListener{listener(conversation)}
        }
    }
}