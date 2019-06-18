package br.com.renanbarbieri.gamestore.presentation.model

/**
 * Created by renan on 13/01/18.
 */
class MainModel{
    val apps = ArrayList<AppModel>()

    constructor()

    constructor(appsList: ArrayList<AppModel>){
        updateAppsList(appsList)
    }

    fun updateAppsList(newApps: ArrayList<AppModel>){
        apps.clear()
        apps += newApps
    }

    override fun toString(): String {
        return "Number of apps: ${apps.size};"
    }
}