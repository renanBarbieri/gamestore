package br.com.renanbarbieri.gamestore.presentation.viewmodel

import android.arch.lifecycle.ViewModel

/**
 * Created by renan on 13/01/18.
 * Creates an minimal requiriment for all application ViewModel.
 * It`s not required to use it, but its advisable
 */
abstract class BaseViewModel<T>: ViewModel() {

    abstract fun initialize(view: T)

}