package br.com.renanbarbieri.bemobichallenge.presentation.viewmodel

import br.com.renanbarbieri.bemobichallenge.domain.interactor.GetAvailableAppsUseCase
import br.com.renanbarbieri.bemobichallenge.presentation.contract.MainContract
import br.com.renanbarbieri.bemobichallenge.presentation.liveData.BaseLiveData
import br.com.renanbarbieri.bemobichallenge.presentation.model.main.MainModel

/**
 * Created by renan on 13/01/18.
 */
class MainViewModel : BaseViewModel<MainContract.View>(), MainContract.ViewModel {

    private var viewInstance: MainContract.View? = null
    private val getAvaliableAppsUseCase = GetAvailableAppsUseCase()

    override fun initialize(view: MainContract.View) {
        viewInstance = view
    }

    /**
     * Implements MainContract.ViewModel
     */
    override fun loadAvailableApps(): BaseLiveData<MainModel> {
        getAvaliableAppsUseCase.execute()
        return BaseLiveData()
    }
}