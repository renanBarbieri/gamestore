package br.com.renanbarbieri.bemobichallenge.presentation.model

import android.graphics.Bitmap

/**
 * Created by renan on 13/01/18.
 */
class App (
    val name: String,
    val price: Float,
    val originalPrice: Float,
    val currency: String,
    val category: Category,
    val bannerUrl: String,
    val iconUrl: String,
    val producer: String,
    val details: String,
    val previews: ArrayList<Bitmap>,
    val size: Int,
    val badges: ArrayList<Badge>,
    val ratingCount: Int,
    val ratingGrade: Float
)