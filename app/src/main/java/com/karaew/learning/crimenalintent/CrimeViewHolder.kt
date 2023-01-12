package com.karaew.learning.crimenalintent


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CrimeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var crime: Crime
    private val titleTextView: TextView = itemView.findViewById(R.id.crime_title)
    private val dateTextView: TextView = itemView.findViewById(R.id.crime_date)

    fun bind(crime: Crime) {
        this.crime = crime
        titleTextView.text = this.crime.title
        dateTextView.text = this.crime.date.toString()
    }

    init {
        itemView.setOnClickListener {
            Toast.makeText(it.context, "Pressed ${crime.title}", Toast.LENGTH_SHORT).show()
        }
    }


}

class CrimeAdapter(var crimes: List<Crime>) : RecyclerView.Adapter<CrimeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeViewHolder {
        return when (viewType) {
            1 -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.list_item_crime, parent, false)
                CrimeViewHolder(view)
            }
            else -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.list_item_critical, parent, false)
                CrimeViewHolder(view)
            }
        }


    }

    override fun onBindViewHolder(holder: CrimeViewHolder, position: Int) {
        val crime = crimes[position]
        holder.bind(crime)
    }

    override fun getItemCount() = crimes.size
    override fun getItemViewType(position: Int): Int {
        return when (crimes[position].requarePolice) {
            true -> 1
            else -> 2
        }
    }

}
