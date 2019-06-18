package br.com.renanbarbieri.gamestore.presentation.liveData

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import br.com.renanbarbieri.gamestore.presentation.liveData.model.ReturnLiveData

/**
 * Created by renan on 13/01/18.
 * Utility to make easier e more comprehensible the liveData.
 * Establish a response pattern
 */
class BaseLiveData<T>: MutableLiveData<ReturnLiveData<T>>() {
    fun observe(owner: LifecycleOwner, observer: BaseObserver<T>) {
        super.observe(owner, observer)
    }
}