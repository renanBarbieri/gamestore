package br.com.renanbarbieri.bemobichallenge.data.repository.mapper

import br.com.renanbarbieri.bemobichallenge.data.model.AvailableAppsResponse
import br.com.renanbarbieri.bemobichallenge.domain.entity.AppEntity

/**
 * Created by renan on 15/01/18.
 */
object AppMapper {

    fun toEntity(appResponse: AvailableAppsResponse.Result): AppEntity{
        return AppEntity(

        )
    }

    fun toEntityList(appsResponse: List<AvailableAppsResponse.Result>): ArrayList<AppEntity>{
        val entityApps: ArrayList<AppEntity> = arrayListOf()
        appsResponse.mapTo(entityApps) { toEntity(it) }
        return entityApps
    }

}