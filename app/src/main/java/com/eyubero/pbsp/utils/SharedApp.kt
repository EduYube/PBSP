package com.eyubero.pbsp.utils

import android.app.Application

class SharedApp : Application() {
    companion object {
        lateinit var prefs: Preferences
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Preferences(applicationContext)
    }
}