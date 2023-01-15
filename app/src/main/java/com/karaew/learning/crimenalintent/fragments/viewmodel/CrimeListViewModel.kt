package com.karaew.learning.crimenalintent.fragments.viewmodel

import androidx.lifecycle.ViewModel
import com.karaew.learning.crimenalintent.repository.CrimeRepository

class CrimeListViewModel:ViewModel() {
  private  val crimeRepository = CrimeRepository.get()
    val crimesListLiveData = crimeRepository.getCrimes()

    }






