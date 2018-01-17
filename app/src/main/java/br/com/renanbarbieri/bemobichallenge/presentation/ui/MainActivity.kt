package br.com.renanbarbieri.bemobichallenge.presentation.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.telephony.TelephonyManager
import android.view.MotionEvent
import android.view.View
import br.com.renanbarbieri.bemobichallenge.R
import br.com.renanbarbieri.bemobichallenge.extensions.info
import br.com.renanbarbieri.bemobichallenge.presentation.contract.MainContract
import br.com.renanbarbieri.bemobichallenge.presentation.liveData.BaseObserver
import br.com.renanbarbieri.bemobichallenge.presentation.model.MainModel
import br.com.renanbarbieri.bemobichallenge.presentation.ui.adapter.AppAdapter
import br.com.renanbarbieri.bemobichallenge.presentation.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainContract.View, AppAdapter.AppAdapterListener {
    private var viewModel: MainViewModel? = null

    var mainView = MainModel()
    private var appsAdapter: AppAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
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
                mainView.updateAppsList(newApps = result.apps)
                appsAdapter?.notifyDataSetChanged()
                pbApps.visibility = View.GONE
                info(mainView.toString())
            }

        })
    }

    private fun initView(){
        appsAdapter = AppAdapter(context = this, data = mainView.apps)
        rvApps.layoutManager = GridLayoutManager(this, 2)
        rvApps.adapter = this.appsAdapter
    }

    override fun onAppSelected(position: Int) {
        info(message = "Cliquei na posição $position")
        AppDetailsActivity.start(callerActivity = this, appSelected = mainView.apps[position])
    }
}
