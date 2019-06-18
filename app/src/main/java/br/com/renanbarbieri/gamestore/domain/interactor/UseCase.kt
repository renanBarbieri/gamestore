package br.com.renanbarbieri.gamestore.domain.interactor

/**
 * Created by renan on 13/01/18.
 */
abstract class UseCase<T> {

    abstract fun execute(callback: UseCaseCallback<T>)

    interface UseCaseCallback<T>{
        fun onSuccess(response: T)
        fun onError(code: Int)
    }

}