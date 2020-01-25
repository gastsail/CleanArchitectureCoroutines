package com.gaston.coroutinesfirebaselivedataclean.domain

import com.gaston.coroutinesfirebaselivedataclean.vo.Resource


/**
 * Created by Gastón Saillén on 15 January 2020
 */
interface IUseCase {

    suspend fun getVersionCode(): Resource<Int>
}