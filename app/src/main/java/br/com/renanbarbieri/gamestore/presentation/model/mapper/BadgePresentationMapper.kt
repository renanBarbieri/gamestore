package br.com.renanbarbieri.gamestore.presentation.model.mapper

import br.com.renanbarbieri.gamestore.domain.entity.BadgeEntity
import br.com.renanbarbieri.gamestore.presentation.model.BadgeModel

/**
 * Created by renan on 15/01/18.
 * Mapper for BadgeModel
 * Its responsible for map the entity into BadgeModel
 */
object BadgePresentationMapper {

    /**
     * Convert a badgeEntity into BadgeModel
     */
    private fun fromEntity(badgeEntity: BadgeEntity): BadgeModel =
            BadgeModel(
                    iconURL = badgeEntity.icon,
                    description = badgeEntity.description
            )

    /**
     * Convert a list of badgeEntity into a list of badgeModel
     */
    fun fromEntities(badgeEntities: List<BadgeEntity>): ArrayList<BadgeModel> =
            badgeEntities.mapTo(ArrayList()){ fromEntity(it) }

}