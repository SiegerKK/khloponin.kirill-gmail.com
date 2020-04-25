package com.example.testmessenger.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testmessenger.R
import com.example.testmessenger.model.Message
import com.example.testmessenger.utils.inflate

class MessageListAdapter (private val messages: List<Message>,
                          private val listener: (Message) -> Unit) : RecyclerView.Adapter<MessageListAdapter.MessageViewHolder>(){
    override fun getItemCount(): Int = messages.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageListAdapter.MessageViewHolder = MessageListAdapter.MessageViewHolder(parent.inflate(R.layout.item_contact_message))
    override fun onBindViewHolder(holder: MessageListAdapter.MessageViewHolder, position: Int) = holder.bind(messages[position], listener)

    //-----------------------Local classes-----------------------//
    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(message: Message, listener: (Message) -> Unit) = with(itemView){
            val imageViewIcon: ImageView = findViewById(R.id.ivUserIcon)
            val textViewText: AppCompatTextView = findViewById(R.id.tvUserMessage)
            val textViewTime: AppCompatTextView = findViewById(R.id.tvUserMessageTime)
            textViewText.text = message.text
            textViewTime.text = message.date.toString()
        }
    }
}