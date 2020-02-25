package com.gaston.coroutinesfirebaselivedataclean.base

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Gastón Saillén on 15 January 2020
 */
abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getViewID())
    }

    protected abstract fun getViewID():Int

    fun showProgress(){
        progressBar.visibility = View.VISIBLE
    }

    fun hideProgress(){
        progressBar.visibility = View.GONE
    }

    fun showUpdateProgress(){

        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder
            .setMessage("Existe una version nueva de esta app, porfavor actualice")
            .setCancelable(false)
            .setPositiveButton("Actualizar ahora") { dialog, which ->
                openAppInPlaystore("com.mobile.legends")
                dialog.dismiss()
            }
            .setNegativeButton("Ahora no") {dialog,which ->
                dialog.dismiss()
            }

        val alert = dialogBuilder.create()
        alert.setTitle("Actualización disponible")
        alert.show()
    }

    private fun openAppInPlaystore(appPackageName: String){
        try{
            startActivity(Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=$appPackageName")))
        }catch (e: ActivityNotFoundException){
            startActivity(Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")))
        }
    }

}