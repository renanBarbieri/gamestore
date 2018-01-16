package br.com.renanbarbieri.bemobichallenge.data.repository

import br.com.renanbarbieri.bemobichallenge.data.contract.AppsDataSourceContract
import br.com.renanbarbieri.bemobichallenge.data.contract.SourceBaseCallback
import br.com.renanbarbieri.bemobichallenge.data.model.AvailableAppsResponse
import br.com.renanbarbieri.bemobichallenge.data.repository.mapper.AppMapper
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
                response?.let {
                    if(response.isSuccessful){
                        response.body()?.let {
                            callback.onSuccess(AppMapper.toEntityList(it.result))
                            return
                        }
                        callback.onError(br.com.renanbarbieri.bemobichallenge.data.model.Error(
                                message = "Body is null",
                                code = null
                        ))
                        return
                    }
                    callback.onError(br.com.renanbarbieri.bemobichallenge.data.model.Error(
                            message = response.errorBody().toString(),
                            code = response.code()
                    ))
                    return
                }

                callback.onError(br.com.renanbarbieri.bemobichallenge.data.model.Error(
                        message = null,
                        code = null
                ))
            }

            override fun onFailure(call: Call<AvailableAppsResponse>?, t: Throwable?) {
                t?.let {
                    callback.onError(
                            br.com.renanbarbieri.bemobichallenge.data.model.Error(
                                    message = t.message,
                                    code = t.hashCode())
                    )
                }
            }
        })
    }
}