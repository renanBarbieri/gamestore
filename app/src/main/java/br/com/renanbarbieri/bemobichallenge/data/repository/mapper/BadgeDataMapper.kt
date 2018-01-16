package br.com.renanbarbieri.bemobichallenge.data.repository.mapper

import br.com.renanbarbieri.bemobichallenge.data.model.AvailableAppsResponse
import br.com.renanbarbieri.bemobichallenge.domain.entity.BadgeEntity

/**
 * Created by renan on 15/01/18.
 */
object BadgeDataMapper {

    private fun toEntity(badgeResponse: AvailableAppsResponse.Badge): BadgeEntity{
        return BadgeEntity(
                icon = badgeResponse.icon,
                description = badgeResponse.description
        )
    }

    fun toEntityList(badgesResponse: List<AvailableAppsResponse.Badge>): ArrayList<BadgeEntity>{
        val entityBadges: ArrayList<BadgeEntity> = arrayListOf()
        badgesResponse.mapTo(entityBadges) { toEntity(it) }
        return entityBadges
    }

}