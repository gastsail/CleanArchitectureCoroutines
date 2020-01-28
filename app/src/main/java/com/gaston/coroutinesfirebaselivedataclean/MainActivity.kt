package com.gaston.coroutinesfirebaselivedataclean

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gaston.coroutinesfirebaselivedataclean.base.BaseActivity
import com.gaston.coroutinesfirebaselivedataclean.data.network.RepoImpl
import com.gaston.coroutinesfirebaselivedataclean.domain.UseCaseImpl
import com.gaston.coroutinesfirebaselivedataclean.presentation.viewmodel.MainViewModel
import com.gaston.coroutinesfirebaselivedataclean.presentation.viewmodel.MainViewModelFactory
import com.gaston.coroutinesfirebaselivedataclean.vo.Resource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val viewModel by lazy { ViewModelProvider(this,MainViewModelFactory(UseCaseImpl(RepoImpl()))).get(MainViewModel::class.java) }

    override fun getViewID(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeData()
    }


    private fun observeData(){

        viewModel.fetchVersionCode.observe(this, Observer { result ->
            when(result){
                is Resource.Loading -> {
                    showProgress()
                }

                is Resource.Success -> {
                    txt_version.text = result.data.toString()
                    hideProgress()
                }

                is Resource.Failure -> {
                    Toast.makeText(this,"Ocurrio un error ${result.exception.message}",Toast.LENGTH_SHORT).show()
                    Log.e("ERROR:",result.exception.message)
                }
            }
        })

    }

}
