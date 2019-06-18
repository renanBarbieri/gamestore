package br.com.renanbarbieri.gamestore.extensions

import android.content.Context
import android.util.Log

/**
 * Created by renan on 16/01/18.
 */
fun Context.info(message: String){
    Log.i(this.javaClass.name, message)
}