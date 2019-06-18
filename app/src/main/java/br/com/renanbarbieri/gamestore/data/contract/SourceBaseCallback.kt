package br.com.renanbarbieri.gamestore.data.contract

import br.com.renanbarbieri.gamestore.data.model.Error

/**
 * Created by renan on 15/01/18.
 */
interface SourceBaseCallback<T> {

    fun onSuccess(response: T)
    fun onError(error: Error)

}