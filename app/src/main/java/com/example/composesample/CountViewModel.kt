package com.example.composesample

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class CountViewModel:ViewModel() {

    val count= mutableStateOf(0)

    fun increaseCount(){
        count.value++
    }

    val myFlow= flow<Int> {
        for (i in 1..100){
            emit(i)
            delay(500)
        }
    }


}