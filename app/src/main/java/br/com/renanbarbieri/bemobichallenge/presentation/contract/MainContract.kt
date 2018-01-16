package br.com.renanbarbieri.bemobichallenge.presentation.contract

import br.com.renanbarbieri.bemobichallenge.presentation.liveData.BaseLiveData
import br.com.renanbarbieri.bemobichallenge.presentation.model.MainModel

/**
 * Created by renan on 13/01/18.
 * Defines an contract between View and ViewModel.
 * This contract is valid only for MainActivity and MainViewModel
 */
interface MainContract {

    interface View{

    }

    interface ViewModel{
        fun loadAvailableApps(): BaseLiveData<MainModel>
    }

}