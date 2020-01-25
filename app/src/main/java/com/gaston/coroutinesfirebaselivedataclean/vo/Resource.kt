package com.gaston.coroutinesfirebaselivedataclean.vo

import java.lang.Exception

/**
 * Created by Gastón Saillén on 15 January 2020
 */
sealed class Resource<out T> {
    class Loading<out T> : Resource<T>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class Failure<out T>(val exception: Exception) : Resource<T>()
}