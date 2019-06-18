package br.com.renanbarbieri.gamestore.data.repository.mapper

import br.com.renanbarbieri.gamestore.data.model.AvailableAppsResponse
import br.com.renanbarbieri.gamestore.domain.entity.AppEntity

/**
 * Created by renan on 15/01/18.
 */
object AppDataMapper {

    private fun toEntity(appResponse: AvailableAppsResponse.Result): AppEntity{
        return AppEntity(
                appId = appResponse.appId,
                publishedAt = appResponse.publishedAt,
                appName = appResponse.appName,
                price = PriceDataMapper.toEntity(appResponse.price),
                category = appResponse.category,
                logoURL = appResponse.logo,
                producer = appResponse.producer,
                bannerURL = appResponse.banner,
                details = appResponse.details,
                previewsURLS = appResponse.preview,
                size = appResponse.size,
                badges = BadgeDataMapper.toEntityList(appResponse.badges),
                rating = RatingDataMapper.toEntity(appResponse.rating)
        )
    }

    fun toEntityList(appsResponse: List<AvailableAppsResponse.Result>): ArrayList<AppEntity>{
        val entityApps: ArrayList<AppEntity> = arrayListOf()
        appsResponse.mapTo(entityApps) { toEntity(it) }
        return entityApps
    }

}