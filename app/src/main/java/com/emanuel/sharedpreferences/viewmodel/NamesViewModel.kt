package com.emanuel.sharedpreferences.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NamesViewModel : ViewModel() {

    private val _listNames = MutableLiveData<String>()
    val listNames: LiveData<String>
        get() = _listNames

    fun saveNames(name: String) {
        _listNames.value = name
    }

    fun clearNames() {
        _listNames.value = ""
    }

    fun setSaveName(name: String) {
        _listNames.value = name
    }
}