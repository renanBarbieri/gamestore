package br.com.renanbarbieri.bemobichallenge.data.repository.mapper

import br.com.renanbarbieri.bemobichallenge.data.model.AvailableAppsResponse
import br.com.renanbarbieri.bemobichallenge.domain.entity.AppEntity
import br.com.renanbarbieri.bemobichallenge.domain.entity.PriceEntity

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