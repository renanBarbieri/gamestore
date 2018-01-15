package br.com.renanbarbieri.bemobichallenge.data.repository

import br.com.renanbarbieri.bemobichallenge.data.contract.AppsDataSourceContract
import br.com.renanbarbieri.bemobichallenge.data.contract.SourceBaseCallback
import br.com.renanbarbieri.bemobichallenge.data.model.AvailableAppsResponse
import br.com.renanbarbieri.bemobichallenge.data.repository.rest.RestAPI
import br.com.renanbarbieri.bemobichallenge.domain.entity.AppEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 *
 * Created by renan on 15/01/18.
 *
 */
object AppsRepository: AppsDataSourceContract{


    override fun fetchApps(callback: SourceBaseCallback<ArrayList<AppEntity>>) {
        RestAPI.appsAPI.getAvailableApps(zone = 4).enqueue(object : Callback<AvailableAppsResponse>{
            override fun onResponse(call: Call<AvailableAppsResponse>?, response: Response<AvailableAppsResponse>?) {

            }

            override fun onFailure(call: Call<AvailableAppsResponse>?, t: Throwable?) {
                t?.let {
                    callback.onError(
                            br.com.renanbarbieri.bemobichallenge.data.model.Error(
                                    message = ""+t.message,
                                    code = t.hashCode())
                    )
                }
            }
        })
    }
}