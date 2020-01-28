package com.gaston.coroutinesfirebaselivedataclean.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.gaston.coroutinesfirebaselivedataclean.domain.IUseCase
import com.gaston.coroutinesfirebaselivedataclean.vo.Resource
import kotlinx.coroutines.Dispatchers

/**
 * Created by Gastón Saillén on 15 January 2020
 */
class MainViewModel(useCase:IUseCase):ViewModel() {

    val fetchVersionCode = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try{
            val version = useCase.getVersionCode()
            emit(version)
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }



}