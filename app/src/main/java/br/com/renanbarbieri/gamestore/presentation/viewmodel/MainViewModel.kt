package br.com.renanbarbieri.gamestore.presentation.viewmodel

import br.com.renanbarbieri.gamestore.R
import br.com.renanbarbieri.gamestore.domain.entity.AppEntity
import br.com.renanbarbieri.gamestore.domain.interactor.GetAvailableAppsUseCase
import br.com.renanbarbieri.gamestore.domain.interactor.UseCase
import br.com.renanbarbieri.gamestore.extensions.guard
import br.com.renanbarbieri.gamestore.presentation.contract.MainContract
import br.com.renanbarbieri.gamestore.presentation.liveData.BaseLiveData
import br.com.renanbarbieri.gamestore.presentation.liveData.model.ErrorLiveData
import br.com.renanbarbieri.gamestore.presentation.liveData.model.ReturnLiveData
import br.com.renanbarbieri.gamestore.presentation.model.MainModel
import br.com.renanbarbieri.gamestore.presentation.model.mapper.MainPresentationMapper

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
     * Require to available apps use case to get the most recent list of apps available.
     * Update the observable with result acquired
     */
    override fun loadAvailableApps(countryCode: String): BaseLiveData<MainModel> {
        availableAppsLiveData.guard {
            availableAppsLiveData = BaseLiveData()
        }

        getAvailableAppsUseCase.execute(countryCode, object : UseCase.UseCaseCallback<ArrayList<AppEntity>>{
            override fun onSuccess(response: ArrayList<AppEntity>) {
                val result = MainPresentationMapper.fromEntity(response)
                val returnLiveData = ReturnLiveData(value = result)
                availableAppsLiveData?.let {
                    it.value = returnLiveData
                    return
                }
                onError(ErrorLiveData.ErrorCode.ERROR_CODE_UNKNOWN)
            }

            override fun onError(code: Int) {
                val error = ErrorLiveData(messageRes = R.string.errorGettingApps, errorCode = ErrorLiveData.ErrorCode(code))
                val returnLiveData = ReturnLiveData<MainModel>(error = error)
                availableAppsLiveData?.let {
                    it.value = returnLiveData
                }
            }
        })
        return availableAppsLiveData!!
    }
}