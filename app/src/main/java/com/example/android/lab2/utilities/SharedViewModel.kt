package com.example.android.lab2.utilities

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private var _bacteria = MutableLiveData<String>()
    private var _bacteriaSpp = MutableLiveData<Int>()
    val bacteria: MutableLiveData<String> = _bacteria
    val bacteriaSpp: MutableLiveData<Int> = _bacteriaSpp

    val saveBacteriaType = { userBacteria: String -> bacteria.value = userBacteria }
    val saveBacteriaSpp = { userBacteriaSpp: Int -> bacteriaSpp.value = userBacteriaSpp }

}