package br.com.renanbarbieri.bemobichallenge.presentation.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.telephony.TelephonyManager
import br.com.renanbarbieri.bemobichallenge.R
import br.com.renanbarbieri.bemobichallenge.extensions.info
import br.com.renanbarbieri.bemobichallenge.presentation.contract.MainContract
import br.com.renanbarbieri.bemobichallenge.presentation.liveData.BaseObserver
import br.com.renanbarbieri.bemobichallenge.presentation.model.MainModel
import br.com.renanbarbieri.bemobichallenge.presentation.viewmodel.MainViewModel


class MainActivity : AppCompatActivity(), MainContract.View {

    private var viewModel: MainViewModel? = null
    private var mainView: MainModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
    }

    /**
     * Initialize the view model to interact with it
     * Besides, request for available apps
     */
    private fun initViewModel(){
        viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        viewModel?.initialize(this)

        val tm = getSystemService(TELEPHONY_SERVICE) as TelephonyManager
        val countryCode = tm.simCountryIso

        viewModel?.loadAvailableApps(countryCode)?.observe(this,  object : BaseObserver<MainModel>{
            override fun onSuccess(result: MainModel) {
                mainView = result

                info(mainView.toString())
                //maybe we need to update the view
            }

        })
    }
}
