package br.com.renanbarbieri.gamestore.data.repository.mapper

import br.com.renanbarbieri.gamestore.data.model.AvailableAppsResponse
import br.com.renanbarbieri.gamestore.domain.entity.PriceEntity

/**
 * Created by renan on 15/01/18.
 */
object PriceDataMapper {

    fun toEntity(priceResponse: AvailableAppsResponse.Price): PriceEntity{
        return PriceEntity(
                currency = priceResponse.currency,
                value = priceResponse.value,
                realValue = priceResponse.realValue
        )
    }

}