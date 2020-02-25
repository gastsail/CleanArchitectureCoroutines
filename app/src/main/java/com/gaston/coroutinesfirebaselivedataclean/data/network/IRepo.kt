package com.gaston.coroutinesfirebaselivedataclean.data.network

import com.gaston.coroutinesfirebaselivedataclean.vo.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by Gastón Saillén on 15 January 2020
 */
interface IRepo {

    suspend fun getVersionCodeRepo(): Flow<Resource<Int>>
}