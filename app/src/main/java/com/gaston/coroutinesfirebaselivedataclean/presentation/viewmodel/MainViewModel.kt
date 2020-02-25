package com.gaston.coroutinesfirebaselivedataclean.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.gaston.coroutinesfirebaselivedataclean.domain.IUseCase
import com.gaston.coroutinesfirebaselivedataclean.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collect

/**
 * Created by Gastón Saillén on 15 January 2020
 */


class MainViewModel(useCase:IUseCase):ViewModel() {

    val fetchVersionCode = liveData(Dispatchers.IO) {
        emit(Resource.Loading())

        try{
            useCase.getVersionCode().collect {
                emit(it)
            }

        }catch (e: Exception){
            emit(Resource.Failure(e))
            Log.e("ERROR:",e.message)
        }
    }
}