package br.com.renanbarbieri.bemobichallenge.presentation.model.mapper

import br.com.renanbarbieri.bemobichallenge.presentation.model.ImageModel

/**
 * Created by renan on 15/01/18.
 * Mapper for ImageModel
 * Its responsible for map the entity into ImageModel
 */
object ImagePresentationMapper {

    /**
     * Convert a string into ImageModel
     */
    fun fromEntity(imgUrl: String): ImageModel =
            ImageModel(url = imgUrl)

    /**
     * Convert a list of strings into list of ImageModel
     */
    fun fromEntities(imageUrlEntities: List<String>): ArrayList<ImageModel> =
            imageUrlEntities.mapTo(ArrayList()){ fromEntity(it) }

}