package br.com.renanbarbieri.bemobichallenge.presentation.viewmodel

import br.com.renanbarbieri.bemobichallenge.domain.entity.AppEntity
import br.com.renanbarbieri.bemobichallenge.domain.interactor.GetAvailableAppsUseCase
import br.com.renanbarbieri.bemobichallenge.domain.interactor.UseCase
import br.com.renanbarbieri.bemobichallenge.extensions.guard
import br.com.renanbarbieri.bemobichallenge.presentation.contract.MainContract
import br.com.renanbarbieri.bemobichallenge.presentation.liveData.BaseLiveData
import br.com.renanbarbieri.bemobichallenge.presentation.model.MainModel

/**
 * Created by renan on 13/01/18.
 */
class MainViewModel : BaseViewModel<MainContract.View>(), MainContract.ViewModel {

    private var viewInstance: MainContract.View? = null
    private var availableAppsLiveData: BaseLiveData<MainModel>? = null
    private val getAvailableAppsUseCase = GetAvailableAppsUseCase()

    override fun initialize(view: MainContract.View) {
        viewInstance = view
    }

    /**
     * Implements MainContract.ViewModel
     */
    override fun loadAvailableApps(): BaseLiveData<MainModel> {
        availableAppsLiveData.guard {
            availableAppsLiveData = BaseLiveData()
        }

        getAvailableAppsUseCase.execute(object : UseCase.UseCaseCallback<ArrayList<AppEntity>>{
            override fun onSuccess(response: ArrayList<AppEntity>) {
                //TODO: convert result to MainModel
                //TODO: update value of livedata
            }

            override fun onError(codeMessage: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
        return availableAppsLiveData!!
    }
}