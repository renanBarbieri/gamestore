package br.com.renanbarbieri.bemobichallenge.data.contract

import br.com.renanbarbieri.bemobichallenge.data.model.Error

/**
 * Created by renan on 15/01/18.
 */
interface SourceBaseCallback<T> {

    fun onSuccess(response: T)
    fun onError(error: Error)

}