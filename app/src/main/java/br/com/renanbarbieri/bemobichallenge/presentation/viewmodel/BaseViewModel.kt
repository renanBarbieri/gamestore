package br.com.renanbarbieri.bemobichallenge.presentation.viewmodel

import android.arch.lifecycle.ViewModel

/**
 * Created by renan on 13/01/18.
 */
abstract class BaseViewModel<T>: ViewModel() {

    abstract fun initialize(view: T)

}