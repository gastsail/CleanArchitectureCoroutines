package com.gaston.coroutinesfirebaselivedataclean.data.network

import com.gaston.coroutinesfirebaselivedataclean.vo.Resource
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.sendBlocking
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

/**
 * Created by Gastón Saillén on 15 January 2020
 */
@ExperimentalCoroutinesApi
class RepoImpl: IRepo {

    // 1 .- Usamos callbackFlow como channelFlow , producimos en un buffer los elementos que vamos a consumir en nuestro viewmodel
    override suspend fun getVersionCodeRepo(): Flow<Resource<Int>> = callbackFlow {

        // 2.- Creamos una referencia al documento en nuestra DB
        val eventDocument =  FirebaseFirestore
            .getInstance()
            .collection("params")
            .document("app")

       // 3.- Generamos una suscripcion que va a emitir datos a nuestro consumidor, para esto usamos el
        // .addSnapshotListener para escuchar por cambios en la base de datos y emitirlos con offer al consumidor en el viewmodel
        val subscription = eventDocument.addSnapshotListener { snapshot, _ ->
            if(snapshot!!.exists()){
                val versionCode = snapshot.getLong("version")
                offer(Resource.Success(versionCode!!.toInt()))
            }

        }

        // Por último , si la UI que esta consumiendo este channel no esta mas activa (es decir, el viewmodel paso por onCleared() y destruyo el collect del flow)
        // cerramos la suscripción para evitar cualquier leak
        awaitClose { subscription.remove() }

    }

}