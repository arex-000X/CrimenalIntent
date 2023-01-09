package com.karaew.learning.crimenalintent

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CrimeViewHolder(view: View) : RecyclerView.ViewHolder(view),View.OnClickListener {

    private lateinit var crime: Crime
    private val titleTextView: TextView = itemView.findViewById(R.id.crime_title)
    private val dateTextView: TextView = itemView.findViewById(R.id.crime_date)
    init {
        itemView.setOnClickListener { this }
    }
    fun bind(crime: Crime) {
        this.crime = crime
        titleTextView.text = this.crime.title
        dateTextView.text = this.crime.date.toString()
    }

    override fun onClick(v: View?) {
      // Toast.makeText(context,"${crime.title} pressed",Toast.LENGTH_SHORT)
    }
}

class CrimeAdapter(var crimes: List<Crime>) : RecyclerView.Adapter<CrimeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_crime, parent, false)
        return CrimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CrimeViewHolder, position: Int) {
        val crime = crimes[position]
        holder.bind(crime)
    }

    override fun getItemCount() = crimes.size

}
