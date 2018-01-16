package br.com.renanbarbieri.bemobichallenge.data.repository.mapper

import br.com.renanbarbieri.bemobichallenge.data.model.AvailableAppsResponse
import br.com.renanbarbieri.bemobichallenge.domain.entity.RatingEntity

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