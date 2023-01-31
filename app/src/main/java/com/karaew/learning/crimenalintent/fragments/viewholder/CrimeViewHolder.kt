package com.karaew.learning.crimenalintent



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.karaew.learning.crimenalintent.database.Crime
import com.karaew.learning.crimenalintent.fragments.viewholder.Callbacks
import java.text.DateFormat


class CrimeViewHolder(view: View,callbacks: Callbacks?) : RecyclerView.ViewHolder(view) {
    private lateinit var crime: Crime
    private val titleTextView: TextView = itemView.findViewById(R.id.crime_title)
    private val dateTextView: TextView = itemView.findViewById(R.id.crime_date)

    fun bind(crime: Crime) {
        this.crime = crime
        titleTextView.text = this.crime.title
        dateTextView.text = DateFormat.getDateInstance().format(this.crime.date)
    }

    init {
        itemView.setOnClickListener {
            callbacks?.onCrimeSelected(crime.id)
        }
    }

}


        class CrimeAdapter(var crimes: List<Crime>,callbacks: Callbacks?) : RecyclerView.Adapter<CrimeViewHolder>() {
          private  var call = callbacks
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeViewHolder {
                return when (viewType) {
                    1 -> {
                        val view =
                            LayoutInflater.from(parent.context)
                                .inflate(R.layout.list_item_crime, parent, false)
                        CrimeViewHolder(view,call)
                    }
                    else -> {
                        val view =
                            LayoutInflater.from(parent.context)
                                .inflate(R.layout.list_item_critical, parent, false)
                        CrimeViewHolder(view,call)
                    }
                }


            }

            override fun onBindViewHolder(holder: CrimeViewHolder, position: Int) {
                val crime = crimes[position]
                holder.bind(crime)
            }

            override fun getItemCount() = crimes.size
            override fun getItemViewType(position: Int): Int {
                return 1

            }
        }

