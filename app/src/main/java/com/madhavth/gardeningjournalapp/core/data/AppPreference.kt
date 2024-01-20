package com.madhavth.gardeningjournalapp.core.data

import android.content.Context
import android.content.SharedPreferences

class AppPreference(context: Context) {
    companion object {
        const val PREFS_NAME = "GardenJournalPrefs"
        const val KEY_FIRST_LAUNCH = "first_launch"
    }

    private val preferences: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    var isFirstLaunch: Boolean
        get() = preferences.getBoolean(KEY_FIRST_LAUNCH, true)
        set(value) = preferences.edit().putBoolean(KEY_FIRST_LAUNCH, value).apply()
}