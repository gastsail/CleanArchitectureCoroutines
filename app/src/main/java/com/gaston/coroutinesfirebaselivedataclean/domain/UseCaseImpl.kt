package com.gaston.coroutinesfirebaselivedataclean.domain

import com.gaston.coroutinesfirebaselivedataclean.data.network.IRepo
import com.gaston.coroutinesfirebaselivedataclean.vo.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by Gastón Saillén on 15 January 2020
 */
class UseCaseImpl(private val repo:IRepo):IUseCase {


    override suspend fun getVersionCode(): Flow<Resource<Int>> = repo.getVersionCodeRepo()
}