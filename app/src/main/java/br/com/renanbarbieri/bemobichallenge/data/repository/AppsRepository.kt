package br.com.renanbarbieri.bemobichallenge.data.repository

import br.com.renanbarbieri.bemobichallenge.data.contract.AppsDataSourceContract
import br.com.renanbarbieri.bemobichallenge.data.contract.SourceBaseCallback
import br.com.renanbarbieri.bemobichallenge.domain.entity.AppEntity

/**
 * Created by renan on 15/01/18.
 */
object AppsRepository: AppsDataSourceContract{

    override fun fetchApps(callback: SourceBaseCallback<ArrayList<AppEntity>>) {
        //aqui pode se acessar a internet, banco de dados interno ou um sharedpreferences
    }
}