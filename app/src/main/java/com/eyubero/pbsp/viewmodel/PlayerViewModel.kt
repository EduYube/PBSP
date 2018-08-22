package com.eyubero.pbsp.viewmodel

import android.arch.lifecycle.ViewModel
import com.eyubero.pbsp.model.PlayerModel
import com.eyubero.pbsp.utils.SharedApp

class PlayerViewModel : ViewModel() {

    var player: PlayerModel? = null

    fun getplayer(): PlayerModel {

        return player!!
    }

    fun setplayer(player: PlayerModel) {

        this.player = player
    }

    fun savePlayer() {

        val sharedPreferences = SharedApp.prefs

        sharedPreferences.sharedName = this.player!!.playerName
        sharedPreferences.sharedTeam = this.player!!.playerTeam
        sharedPreferences.sharedAge = this.player!!.playerAge
        sharedPreferences.sharedDomination = this.player!!.playerDomination
        sharedPreferences.sharedNationality = this.player!!.playerNationality
        sharedPreferences.sharedPosition = this.player!!.playerPosition
    }
}