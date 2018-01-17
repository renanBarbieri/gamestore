package br.com.renanbarbieri.bemobichallenge.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.widget.NestedScrollView
import android.support.v7.app.AppCompatActivity
import br.com.renanbarbieri.bemobichallenge.R
import br.com.renanbarbieri.bemobichallenge.presentation.model.AppModel
import br.com.renanbarbieri.bemobichallenge.presentation.model.DetailsModel
import kotlinx.android.synthetic.main.activity_app_details.*
import kotlinx.android.synthetic.main.content_app_details.*

class AppDetailsActivity : AppCompatActivity() {

    var detailsView: DetailsModel? = null

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
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        intent?.extras?.let {
            if(it.containsKey(ARG_APP_SELECTED)){
                this.detailsView = DetailsModel(it.get(ARG_APP_SELECTED) as AppModel)
                initView()
            }
        }
    }

    private fun initView(){
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Função ainda não implementada", Snackbar.LENGTH_LONG).show()
        }

        nsvAppDetailsContent.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { nestedScrollView, scrollX, scrollY, oldScrollX, oldScrollY ->
            nestedScrollView?.let {
                if (scrollY == (nestedScrollView.getChildAt(0).measuredHeight - nestedScrollView.measuredHeight)) {
                    fab.hide()
                }
                else if(!fab.isShown){
                    fab.show()
                }
            }
        })
    }
}
