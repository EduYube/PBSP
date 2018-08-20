package com.eyubero.pbsp.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel

class PlayerViewModel: ViewModel() {

    lateinit var playerName: LiveData<String>
    lateinit var playerTeam: LiveData<String>
    lateinit var playerAge: LiveData<Int>
    lateinit var playerDomination: LiveData<String>
    lateinit var playerNationality: LiveData<String>
}