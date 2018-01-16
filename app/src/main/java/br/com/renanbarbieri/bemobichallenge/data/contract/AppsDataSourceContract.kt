package br.com.renanbarbieri.bemobichallenge.data.contract

import br.com.renanbarbieri.bemobichallenge.domain.entity.AppEntity

/**
 * Created by renan on 15/01/18.
 */
interface AppsDataSourceContract {

    fun fetchApps(countryCode: String, callback: SourceBaseCallback<ArrayList<AppEntity>>)

}