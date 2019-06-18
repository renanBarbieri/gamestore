package br.com.renanbarbieri.gamestore.extensions

/**
 * Created by renan on 13/01/18.
 */
inline fun <T> T.guard(block: T.() -> Unit): T {
    if (this == null) block(); return this
}