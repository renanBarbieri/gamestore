package br.com.renanbarbieri.gamestore.presentation.model.mapper

import br.com.renanbarbieri.gamestore.domain.entity.AppEntity
import br.com.renanbarbieri.gamestore.presentation.model.MainModel

/**
 * Created by renan on 15/01/18.
 * Mapper for main screen model.
 * Its responsible for map the entity into MainModel
 */
object MainPresentationMapper {

    /**
     * Convert a list of AppEntity into MainModel
     */
    fun fromEntity(appsEntity: ArrayList<AppEntity>): MainModel =
            MainModel(appsEntity.mapTo(ArrayList()){ AppPresentationMapper.fromEntity(it) })

}