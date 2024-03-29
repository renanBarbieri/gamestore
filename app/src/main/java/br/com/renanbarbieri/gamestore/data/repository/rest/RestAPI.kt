package br.com.renanbarbieri.gamestore.data.repository.rest

import br.com.renanbarbieri.gamestore.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by renan on 15/01/18.
 */
object RestAPI {

    val appsAPI: AppsInterface

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.API_DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttp())
                .build()

        appsAPI = retrofit.create(AppsInterface::class.java)
    }

    private fun getOkHttp(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        return OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .build()
    }

}