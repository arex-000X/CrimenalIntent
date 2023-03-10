package com.karaew.learning.crimenalintent.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.karaew.learning.crimenalintent.CrimeAdapter
import com.karaew.learning.crimenalintent.R
import com.karaew.learning.crimenalintent.database.Crime
import com.karaew.learning.crimenalintent.fragments.viewholder.Callbacks
import com.karaew.learning.crimenalintent.fragments.viewmodel.CrimeListViewModel


const val TAG = "CrimeListFragment"


class CrimeListFragment : Fragment() {
    private var callbacks:Callbacks? = null
    private var adapter: CrimeAdapter? = CrimeAdapter(emptyList(),callbacks)
    lateinit var crimeRecylerView: RecyclerView
    val crimeListViewModel: CrimeListViewModel by lazy {
        ViewModelProvider(this).get(CrimeListViewModel::class.java)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        crimeRecylerView = view.findViewById(R.id.crime_recyler_view) as RecyclerView
        crimeRecylerView.layoutManager = LinearLayoutManager(context)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        crimeListViewModel.crimesListLiveData.observe(
            viewLifecycleOwner,
            Observer { crimes ->
                crimes?.let {
                    Log.i(TAG, "Got crimes ${crimes.size}")
                    updateUI(crimes)
                }
            }
        )
    }

    override fun onDetach() {
        super.onDetach()
    callbacks = null
    }


    fun updateUI(crimes: List<Crime>) {
        adapter = CrimeAdapter(crimes,callbacks)
        crimeRecylerView.adapter = adapter
    }




    companion object {
        fun newInstance(): CrimeListFragment {
            return CrimeListFragment()
        }
    }
}

