package com.karaew.learning.crimenalintent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CrimeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val titleTextView: TextView = itemView.findViewById(R.id.crime_title)
    val dateTextView: TextView = itemView.findViewById(R.id.crime_date)
}

class CrimeAdapter(var crimes: List<Crime>) : RecyclerView.Adapter<CrimeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_crime, parent, false)
        return CrimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CrimeViewHolder, position: Int) {
        val crime = crimes[position]
        holder.apply {
            titleTextView.text = crime.title
            dateTextView.text = crime.date.toString()
        }
    }

    override fun getItemCount() = crimes.size

}
