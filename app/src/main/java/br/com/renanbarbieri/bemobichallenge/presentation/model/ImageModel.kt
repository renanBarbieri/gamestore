package br.com.renanbarbieri.bemobichallenge.presentation.model

import android.graphics.Bitmap

/**
 * Created by renan on 16/01/18.
 */
class ImageModel {
    var url: String? = null
    var bmp: Bitmap? = null

    constructor()

    constructor(url: String){
        this.url = url
    }
}