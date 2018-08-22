package com.eyubero.pbsp.model

/**
 * Created by Edu Yube ┌(▀Ĺ̯ ▀-͠ )┐
 * on 31/07/2018 (ノಠ益ಠ)ノ
 */
class PlayerModel {

    lateinit var playerTeam: String
    lateinit var playerName: String
    lateinit var playerAge: String
    lateinit var playerPosition: String
    lateinit var plyaerDomination: String
    lateinit var playerNationality: String

    fun getplayerName(): String{

        return playerName
    }

    fun setplayerName(playerName: String){

        this.playerName = playerName
    }

    fun getplayerTeam(): String{

        return playerTeam
    }

    fun setplayerTeam(playerTeam: String){

        this.playerTeam = playerTeam
    }

    fun getplayerAge(): String{

        return playerAge
    }

    fun setplayerAge(playerAge: String){

        this.playerAge = playerAge
    }

    fun getplayerPosition(): String{

        return playerPosition
    }

    fun setplayerPosition(playerPosition: String){

        this.playerPosition = playerPosition
    }

    fun getplayerDomination(): String{

        return plyaerDomination
    }

    fun setplayerDomination(playerDomination: String){

        this.plyaerDomination = playerDomination
    }

    fun getplayerNationality(): String{

        return playerNationality
    }

    fun setplayerNationality(playerNationality: String){

        this.playerNationality = playerNationality
    }
}
