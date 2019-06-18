package br.com.renanbarbieri.gamestore.data.repository.mapper

import br.com.renanbarbieri.gamestore.data.model.AvailableAppsResponse
import br.com.renanbarbieri.gamestore.domain.entity.RatingEntity

/**
 * Created by renan on 15/01/18.
 */
object RatingDataMapper {

    fun toEntity(ratingResponse: AvailableAppsResponse.Rating): RatingEntity {
        return RatingEntity(
                count = ratingResponse.count,
                grade = ratingResponse.grade
        )
    }

}