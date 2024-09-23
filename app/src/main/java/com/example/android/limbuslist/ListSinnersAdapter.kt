package com.example.android.limbuslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView

class ListSinnersAdapter(
    private val listSinners: ArrayList<Sinners>, private val navController: NavController
) : RecyclerView.Adapter<ListSinnersAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.sinners_card, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, quote, photoWide) = listSinners[position]
        holder.sinnersName.text = name
        holder.sinnersQuote.text = quote
        holder.sinnersPhoto.setImageResource(photoWide)
        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Kamu memilih " + listSinners[holder.adapterPosition].name,
                Toast.LENGTH_SHORT
            ).show()
            val sinnersDetails = Bundle().apply {
                putString("sinnerName", name)
                putString("sinnerQuote", quote)
                putInt("sinnerPhoto", photoWide)
            }
            navController.navigate(R.id.action_FirstFragment_to_DetailFragment, sinnersDetails)
        }
    }

    override fun getItemCount(): Int = listSinners.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sinnersPhoto: ImageView = itemView.findViewById(R.id.sinners_photo)
        val sinnersName: TextView = itemView.findViewById(R.id.sinners_name)
        val sinnersQuote: TextView = itemView.findViewById(R.id.sinners_quote)
    }
}
