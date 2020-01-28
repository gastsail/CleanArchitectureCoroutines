package com.gaston.coroutinesfirebaselivedataclean.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gaston.coroutinesfirebaselivedataclean.domain.IUseCase

/**
 * Created by Gastón Saillén on 28 January 2020
 */
class MainViewModelFactory(private val useCase: IUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(IUseCase::class.java).newInstance(useCase)
    }
}