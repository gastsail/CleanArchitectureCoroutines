package com.gaston.coroutinesfirebaselivedataclean.data.network

import com.gaston.coroutinesfirebaselivedataclean.vo.Resource
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

/**
 * Created by Gastón Saillén on 15 January 2020
 */
class RepoImpl: IRepo {

    override suspend fun getVersionCodeRepo(): Resource<Int> {
        val resultData = FirebaseFirestore.getInstance()
            .collection("params").document("app").get().await()
        val versionCode = resultData.getLong("version")
        return Resource.Success(versionCode!!.toInt())
    }
}