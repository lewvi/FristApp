package com.example.fristapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class addContacttAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<addContacttAdapter.WordViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var adds = emptyList<addContact>()

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = adds[position]
        holder.wordItemView.text = current.add
    }

    internal fun setWords(words: List<addContact>) {
        this.adds = words
        notifyDataSetChanged()
    }

    override fun getItemCount() = adds.size
}