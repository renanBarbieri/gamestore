package br.com.renanbarbieri.gamestore.data.contract

import br.com.renanbarbieri.gamestore.domain.entity.AppEntity

/**
 * Created by renan on 15/01/18.
 */
interface AppsDataSourceContract {

    fun fetchApps(countryCode: String, callback: SourceBaseCallback<ArrayList<AppEntity>>)

}