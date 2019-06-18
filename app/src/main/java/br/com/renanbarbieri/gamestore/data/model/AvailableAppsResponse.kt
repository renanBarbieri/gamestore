package br.com.renanbarbieri.gamestore.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by renan on 15/01/18.
 */
class AvailableAppsResponse (
    @SerializedName("status") var status: String,
    @SerializedName("result") var result: List<Result>) {

    class Badge(
        @SerializedName("icon") var icon: String,
        @SerializedName("description") var description: String
    )

    class Price (
        @SerializedName("currency") var currency: String,
        @SerializedName("value") var value: Double,
        @SerializedName("realValue") var realValue: Double
    )

    class Rating(
        @SerializedName("count") var count: Int,
        @SerializedName("grade") var grade: Double
    )

    class Result(
        @SerializedName("appId") var appId: String,
        @SerializedName("published_at") var publishedAt: Date,
        @SerializedName("appName") var appName: String,
        @SerializedName("price") var price: Price,
        @SerializedName("category") var category: String,
        @SerializedName("logo") var logo: String,
        @SerializedName("producer") var producer: String,
        @SerializedName("banner") var banner: String,
        @SerializedName("details") var details: String,
        @SerializedName("preview") var preview: List<String>,
        @SerializedName("size") var size: Int,
        @SerializedName("badges") var badges: List<Badge>,
        @SerializedName("rating") var rating: Rating
    )
}