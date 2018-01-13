package br.com.renanbarbieri.bemobichallenge.presentation.liveData

import android.arch.lifecycle.Observer
import br.com.renanbarbieri.bemobichallenge.presentation.liveData.model.ReturnLiveData

/**
 * Created by renan on 13/01/18.
 */
interface BaseObserver<T> : Observer<ReturnLiveData<T>> {
    override fun onChanged(result: ReturnLiveData<T>?) {
        result?.let {
            it.error?.let {
                onError(it.message, it.errorCode.code)
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

    fun onError(message: String, code: Int) {}
    fun onSuccess(result: T)
    fun onEmptyResult() {}
}