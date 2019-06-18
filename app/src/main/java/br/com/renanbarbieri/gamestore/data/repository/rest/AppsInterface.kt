package br.com.renanbarbieri.gamestore.data.repository.rest

import br.com.renanbarbieri.gamestore.BuildConfig
import br.com.renanbarbieri.gamestore.data.model.AvailableAppsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by renan on 15/01/18.
 */
interface AppsInterface {

    @GET(BuildConfig.API_PATH)
    fun getAvailableApps(
            @Query("z") zone: String
    ): Call<AvailableAppsResponse>

}