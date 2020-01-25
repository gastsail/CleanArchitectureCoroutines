package com.gaston.coroutinesfirebaselivedataclean.data.network

import com.gaston.coroutinesfirebaselivedataclean.vo.Resource

/**
 * Created by Gastón Saillén on 15 January 2020
 */
interface IRepo {

    suspend fun getVersionCodeRepo(): Resource<Int>
}