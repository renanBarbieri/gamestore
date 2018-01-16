package br.com.renanbarbieri.bemobichallenge.presentation.model

/**
 * Created by renan on 13/01/18.
 */
class AppModel(
        val id: String,
        val name: String,
        val price: Double,
        val originalPrice: Double,
        val currency: String,
        val category: CategoryModel,
        val banner: ImageModel,
        val icon: ImageModel,
        val producer: String,
        val details: String,
        val previews: ArrayList<ImageModel>,
        val size: Int,
        val badges: ArrayList<BadgeModel>,
        val ratingCount: Int,
        val ratingGrade: Double
)