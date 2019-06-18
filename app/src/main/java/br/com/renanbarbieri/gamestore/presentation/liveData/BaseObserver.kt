package br.com.renanbarbieri.gamestore.presentation.liveData

import android.arch.lifecycle.Observer
import br.com.renanbarbieri.gamestore.presentation.liveData.model.ReturnLiveData

/**
 * Created by renan on 13/01/18.
 */
interface BaseObserver<T> : Observer<ReturnLiveData<T>> {
    override fun onChanged(result: ReturnLiveData<T>?) {
        result?.let {
            it.error?.let {
                onError(it.messageRes, it.errorCode.code)
                return
            }

            it.value?.let {
                onSuccess(it)
                return
            }
            return@let
        }
        onEmptyResult()
    }

    fun onError(message: Int, code: Int) {}
    fun onSuccess(result: T)
    fun onEmptyResult() {}
}