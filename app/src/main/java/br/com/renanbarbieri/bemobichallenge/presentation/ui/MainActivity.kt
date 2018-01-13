package br.com.renanbarbieri.bemobichallenge.presentation.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.renanbarbieri.bemobichallenge.R
import br.com.renanbarbieri.bemobichallenge.presentation.contract.MainContract

class MainActivity : AppCompatActivity(), MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
