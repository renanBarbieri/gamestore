package br.com.renanbarbieri.bemobichallenge.presentation.viewmodel

import br.com.renanbarbieri.bemobichallenge.presentation.contract.MainContract
import br.com.renanbarbieri.bemobichallenge.presentation.liveData.BaseLiveData

/**
 * Created by renan on 13/01/18.
 */
class MainViewModel : BaseViewModel<MainContract.View>(), MainContract.ViewModel {

    private var viewInstance: MainContract.View? = null

    override fun initialize(view: MainContract.View) {
        viewInstance = view
    }

    /**
     * Implements MainContract.ViewModel
     */
    override fun loadAvaliableApps(): BaseLiveData<Any> {
        return BaseLiveData()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}