package br.com.renanbarbieri.bemobichallenge.presentation.ui

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.renanbarbieri.bemobichallenge.R
import br.com.renanbarbieri.bemobichallenge.presentation.contract.MainContract
import br.com.renanbarbieri.bemobichallenge.presentation.viewmodel.MainViewModel
import br.com.renanbarbieri.bemobichallenge.presentation.liveData.BaseObserver
import br.com.renanbarbieri.bemobichallenge.presentation.model.main.MainModel

class MainActivity : AppCompatActivity(), MainContract.View {

    private var viewModel: MainViewModel? = null
    private var mainView: MainModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
    }

    private fun initViewModel(){
        viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        viewModel?.initialize(this)
        viewModel?.loadAvailableApps()?.observe(this,  object : BaseObserver<MainModel>{
            override fun onSuccess(result: MainModel) {
                mainView = result
                //maybe we need to update the view
            }

        })
    }
}
