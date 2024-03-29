package br.com.renanbarbieri.gamestore.data.repository

import br.com.renanbarbieri.gamestore.data.contract.AppsDataSourceContract
import br.com.renanbarbieri.gamestore.data.contract.SourceBaseCallback
import br.com.renanbarbieri.gamestore.data.model.AvailableAppsResponse
import br.com.renanbarbieri.gamestore.data.repository.mapper.AppDataMapper
import br.com.renanbarbieri.gamestore.data.repository.rest.RestAPI
import br.com.renanbarbieri.gamestore.domain.entity.AppEntity
import br.com.renanbarbieri.gamestore.presentation.liveData.model.ErrorLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 *
 * Created by renan on 15/01/18.
 *
 */
object AppsRepository: AppsDataSourceContract{

    /**
     * Call RestAPI to get the apps.
     * The API URL is defined at buildParameters.gradle
     */
    override fun fetchApps(countryCode:String , callback: SourceBaseCallback<ArrayList<AppEntity>>) {
        RestAPI.appsAPI.getAvailableApps(zone = countryCode).enqueue(object : Callback<AvailableAppsResponse>{
            override fun onResponse(call: Call<AvailableAppsResponse>?, response: Response<AvailableAppsResponse>?) {
                response?.let {
                    if(response.isSuccessful){
                        response.body()?.let {
                            callback.onSuccess(AppDataMapper.toEntityList(it.result))
                            return
                        }
                        callback.onError(br.com.renanbarbieri.gamestore.data.model.Error(
                                message = "Body is null",
                                code = ErrorLiveData.ErrorCode.ERROR_CODE_BODY_NULL
                        ))
                        return
                    }
                    callback.onError(br.com.renanbarbieri.gamestore.data.model.Error(
                            message = response.errorBody().toString(),
                            code = response.code()
                    ))
                    return
                }

                callback.onError(br.com.renanbarbieri.gamestore.data.model.Error(
                        message = null,
                        code = ErrorLiveData.ErrorCode.ERROR_CODE_HTTP_NO_RESPONSE
                ))
            }

            override fun onFailure(call: Call<AvailableAppsResponse>?, t: Throwable?) {
                t?.let {
                    callback.onError(
                            br.com.renanbarbieri.gamestore.data.model.Error(
                                    message = t.message,
                                    code = t.hashCode())
                    )
                }
            }
        })
    }
}