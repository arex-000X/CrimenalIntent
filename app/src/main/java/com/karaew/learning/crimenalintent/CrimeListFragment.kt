package com.karaew.learning.crimenalintent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

const val TAG = "CrimeListFragment"
private var adapter: CrimeAdapter? = null

class CrimeListFragment : Fragment() {
    lateinit var crimeRecylerView: RecyclerView
    val crimeListViewModel: CrimeListViewModel by lazy {
        ViewModelProvider(this).get(CrimeListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total crimes:${crimeListViewModel.crimes.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        crimeRecylerView = view.findViewById(R.id.crime_recyler_view) as RecyclerView
        crimeRecylerView.layoutManager = LinearLayoutManager(context)
        updateUI()
        return view
    }

    fun updateUI() {

        val crimes = crimeListViewModel.crimes
        adapter = CrimeAdapter(crimes)
        crimeRecylerView.adapter = adapter
    }

    companion object {
        fun newInstance(): CrimeListFragment {
            return CrimeListFragment()
        }
    }
}

