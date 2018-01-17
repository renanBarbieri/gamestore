package br.com.renanbarbieri.bemobichallenge.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import br.com.renanbarbieri.bemobichallenge.R
import br.com.renanbarbieri.bemobichallenge.presentation.model.AppModel
import kotlinx.android.synthetic.main.activity_app_details.*

class AppDetailsActivity : AppCompatActivity() {

    companion object {
        private val ARG_APP_SELECTED = AppDetailsActivity::class.java.canonicalName+"ARG_APP_SELECTED"

        fun start(callerActivity: AppCompatActivity, appSelected: AppModel){
            val openThisActivity = Intent(callerActivity, AppDetailsActivity::class.java)
            openThisActivity.putExtra(ARG_APP_SELECTED, appSelected)
            callerActivity.startActivity(openThisActivity)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_details)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
