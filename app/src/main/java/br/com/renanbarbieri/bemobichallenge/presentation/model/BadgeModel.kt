package br.com.renanbarbieri.bemobichallenge.presentation.model

import android.graphics.Bitmap
import java.io.Serializable

/**
 * Created by renan on 13/01/18.
 */
class BadgeModel: Serializable{

    var iconURL: String? = null
    var icon: Bitmap? = null
    var description: String? = null

    constructor()

    constructor(iconURL: String, description: String){
        this.iconURL = iconURL
        this.description = description
    }
}