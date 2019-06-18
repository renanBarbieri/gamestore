package br.com.renanbarbieri.gamestore.domain.entity

import java.util.*

/**
 * Created by renan on 13/01/18.
 */
class AppEntity (
        var appId: String,
        var publishedAt: Date,
        var appName: String,
        var price: PriceEntity,
        var category: String,
        var logoURL: String,
        var producer: String,
        var bannerURL: String,
        var details: String,
        var previewsURLS: List<String>,
        var size: Int,
        var badges: List<BadgeEntity>,
        var rating: RatingEntity
)