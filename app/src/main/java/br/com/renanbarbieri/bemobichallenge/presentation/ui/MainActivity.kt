package br.com.renanbarbieri.bemobichallenge.presentation.ui

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.renanbarbieri.bemobichallenge.R
import br.com.renanbarbieri.bemobichallenge.presentation.contract.MainContract
import br.com.renanbarbieri.bemobichallenge.presentation.viewmodel.MainViewModel
import br.com.renanbarbieri.bemobichallenge.presentation.liveData.BaseObserver

class MainActivity : AppCompatActivity(), MainContract.View {

    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
    }

    private fun initViewModel(){
        viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        viewModel?.initialize(this)
        viewModel?.loadAvaliableApps()?.observe(this,  object : BaseObserver<Any>{
            override fun onSuccess(result: Any) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }
}
