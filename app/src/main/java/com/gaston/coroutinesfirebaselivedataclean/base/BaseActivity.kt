package com.gaston.coroutinesfirebaselivedataclean.base

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
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

}