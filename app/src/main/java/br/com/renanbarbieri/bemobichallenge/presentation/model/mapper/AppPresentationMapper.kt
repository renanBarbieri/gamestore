package br.com.renanbarbieri.bemobichallenge.presentation.model.mapper

import br.com.renanbarbieri.bemobichallenge.domain.entity.AppEntity
import br.com.renanbarbieri.bemobichallenge.presentation.model.AppModel
import br.com.renanbarbieri.bemobichallenge.presentation.model.CategoryModel

/**
 * Created by renan on 16/01/18.
 * Mapper for AppModel
 * Its responsible for map the entity into AppModel
 */
object AppPresentationMapper {

    /**
     * Convert a appEntity into AppModel
     * Use another Mappers no construct the final model
     * No special rules for conversion
     */
    fun fromEntity(appEntity: AppEntity): AppModel = AppModel(
        id = appEntity.appId,
        name = appEntity.appName,
        price = appEntity.price.value,
        originalPrice = appEntity.price.realValue,
        currency = appEntity.price.currency,
        category = CategoryModel(appEntity.category),
        banner = ImagePresentationMapper.fromEntity(appEntity.bannerURL),
        icon = ImagePresentationMapper.fromEntity(appEntity.logoURL),
        producer = appEntity.producer,
        details = appEntity.details,
        previews = ImagePresentationMapper.fromEntities(appEntity.previewsURLS),
        size = appEntity.size,
        badges = BadgePresentationMapper.fromEntities(appEntity.badges),
        ratingCount = appEntity.rating.count,
        ratingGrade = appEntity.rating.grade
    )

}