package br.com.renanbarbieri.bemobichallenge.presentation.model

/**
 * Created by renan on 13/01/18.
 */
class MainModel (val apps: ArrayList<AppModel>){
    override fun toString(): String {
        return "Number of apps: ${apps.size};"
    }
}