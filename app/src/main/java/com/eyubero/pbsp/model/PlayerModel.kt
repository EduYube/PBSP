package com.eyubero.pbsp.model

/**
 * Created by Edu Yube ┌(▀Ĺ̯ ▀-͠ )┐
 * on 31/07/2018 (ノಠ益ಠ)ノ
 */
class PlayerModel (team: String, name: String, age: Int, position: String, domination: String, nationality: String){

    lateinit var playerTeam: String
    lateinit var playerName: String
    var playerAge: Int = 0
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

    fun getplayerAge(): Int{

        return playerAge
    }

    fun setplayerAge(playerAge: Int){

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
