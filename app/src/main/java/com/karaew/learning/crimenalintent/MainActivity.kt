package com.karaew.learning.crimenalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.karaew.learning.crimenalintent.fragments.CrimeFragment
import com.karaew.learning.crimenalintent.fragments.CrimeListFragment
import com.karaew.learning.crimenalintent.fragments.viewholder.Callbacks
import java.util.*

class MainActivity : AppCompatActivity(), Callbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currentFragment == null) {
            val fragment = CrimeListFragment()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment)
                .commit()
        }


    }

    override fun onCrimeSelected(crimeId: UUID) {
        val fragment = CrimeFragment()
        supportFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.fragment_container, fragment).commit()
    }

}