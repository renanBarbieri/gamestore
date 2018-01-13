package br.com.renanbarbieri.bemobichallenge.presentation.contract

import br.com.renanbarbieri.bemobichallenge.presentation.liveData.BaseLiveData

/**
 * Created by renan on 13/01/18.
 */
interface MainContract {

    interface View{

    }

    interface ViewModel{
        fun loadAvaliableApps(): BaseLiveData<Any>
    }

}