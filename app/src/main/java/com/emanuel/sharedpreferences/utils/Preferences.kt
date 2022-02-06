package com.emanuel.sharedpreferences.utils

import android.content.Context

class Preferences(context: Context) {

    private val prefes = context.getSharedPreferences(KEY_STRING_NAMES, Context.MODE_PRIVATE)

    companion object {
        const val KEY_STRING_NAMES = "com.emanuel.sharedpreferences.NAMES"
        const val DEFAULT_VALUE = ""
    }

    fun saveNames(listNames: String?) {
        with(prefes.edit()) {
            putString(KEY_STRING_NAMES, listNames)
            commit()
        }
    }

    fun readNames(): String? {
        return prefes.getString(KEY_STRING_NAMES, DEFAULT_VALUE)
    }
}