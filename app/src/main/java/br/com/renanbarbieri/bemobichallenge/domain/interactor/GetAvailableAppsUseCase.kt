package br.com.renanbarbieri.bemobichallenge.domain.interactor

import br.com.renanbarbieri.bemobichallenge.data.contract.AppsDataSourceContract
import br.com.renanbarbieri.bemobichallenge.data.contract.SourceBaseCallback
import br.com.renanbarbieri.bemobichallenge.data.model.Error
import br.com.renanbarbieri.bemobichallenge.data.repository.AppsRepository
import br.com.renanbarbieri.bemobichallenge.domain.entity.AppEntity
import br.com.renanbarbieri.bemobichallenge.presentation.liveData.model.ErrorLiveData

/**
 * Created by renan on 13/01/18.
 * User case for get available appes
 */
class GetAvailableAppsUseCase : UseCase<ArrayList<AppEntity>>() {

    private val appRepository: AppsDataSourceContract = AppsRepository

    /**
     * Call the repository to fetch apps.
     */
    override fun execute(callback: UseCaseCallback<ArrayList<AppEntity>>) {
        appRepository.fetchApps(object : SourceBaseCallback<ArrayList<AppEntity>>{
            override fun onSuccess(response: ArrayList<AppEntity>) {
                callback.onSuccess(response)
            }

            override fun onError(error: Error) {
                callback.onError(error.code ?: ErrorLiveData.ErrorCode.ERROR_CODE_UNKNOWN)
            }
        })
    }
}