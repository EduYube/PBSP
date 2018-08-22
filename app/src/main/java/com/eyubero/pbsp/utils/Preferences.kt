package com.eyubero.pbsp.utils

import android.content.Context
import android.content.SharedPreferences

class Preferences(context: Context) {

    val SHARED_NAME = "player name"
    val SHARED_TEAM = "player team"
    val SHARED_AGE = "player age"
    val SHARED_POSITION = "player position"
    val SHARED_DOMINATION = "player domination"
    val SHARED_NATIONALITY = "player nationality"

    val prefs: SharedPreferences = context.getSharedPreferences("Shared Preferences", 0)


    var sharedName: String
        get() = prefs.getString(SHARED_NAME, "")
        set(value) = prefs.edit().putString(SHARED_NAME, value).apply()

    var sharedTeam: String
        get() = prefs.getString(SHARED_TEAM, "")
        set(value) = prefs.edit().putString(SHARED_TEAM, value).apply()

    var sharedAge: String
        get() = prefs.getString(SHARED_AGE, "")
        set(value) = prefs.edit().putString(SHARED_AGE, value).apply()

    var sharedPosition: String
        get() =  prefs.getString(SHARED_POSITION,"")
        set(value) = prefs.edit().putString(SHARED_POSITION,value).apply()

    var sharedDomination: String
        get() = prefs.getString(SHARED_DOMINATION,"")
        set(value) = prefs.edit().putString(SHARED_DOMINATION,value).apply()

    var sharedNationality: String
        get() = prefs.getString(SHARED_NATIONALITY,"")
        set(value) = prefs.edit().putString(SHARED_NATIONALITY,value).apply()
}