package com.example.android.limbuslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListSinnersAdapter(private val listSinners: ArrayList<Sinners>) : RecyclerView.Adapter<ListSinnersAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.sinners_card, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, quote, photoWide) = listSinners[position]
        holder.sinnersPhoto.setImageResource(photoWide)
        holder.sinnersName.text = name
        holder.sinnersQuote.text = quote
    }

    override fun getItemCount(): Int = listSinners.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sinnersPhoto: ImageView = itemView.findViewById(R.id.sinners_photo)
        val sinnersName: TextView = itemView.findViewById(R.id.sinners_name)
        val sinnersQuote: TextView = itemView.findViewById(R.id.sinners_quote)
    }
}