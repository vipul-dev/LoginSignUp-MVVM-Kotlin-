package com.dev.pvaeps.utils

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {
    private const val NAME = "PvAeps"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences
    private val ACCESS_TOKEN = Pair("access_token", "")

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    fun clearPreference() {
        preferences.edit().clear().apply()
    }

    var userAccessToken: String
        get() =
            preferences.getString(ACCESS_TOKEN.first, ACCESS_TOKEN.second).toString()
        set(value) =
            preferences.edit {
            it.putString(ACCESS_TOKEN.first, value)
        }


}