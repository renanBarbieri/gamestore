package br.com.renanbarbieri.bemobichallenge.presentation.ui

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.widget.NestedScrollView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import br.com.renanbarbieri.bemobichallenge.GlideApp
import br.com.renanbarbieri.bemobichallenge.R
import br.com.renanbarbieri.bemobichallenge.presentation.model.AppModel
import br.com.renanbarbieri.bemobichallenge.presentation.model.DetailsModel
import br.com.renanbarbieri.bemobichallenge.presentation.ui.adapter.BadgeAdapter
import br.com.renanbarbieri.bemobichallenge.presentation.ui.adapter.PreviewAdapter
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.activity_app_details.*
import kotlinx.android.synthetic.main.content_app_details.*
import kotlinx.android.synthetic.main.item_app.view.*

class AppDetailsActivity : AppCompatActivity() {

    var detailsView: DetailsModel? = null
    var badgeAdapter: BadgeAdapter? = null
    var previewAdapter: PreviewAdapter? = null

    companion object {
        val ARG_APP_SELECTED = AppDetailsActivity::class.java.canonicalName+"ARG_APP_SELECTED"

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

        detailsView?.let {
            badgeAdapter = BadgeAdapter(context = this, data = it.app.badges)
            rvBadges.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false)
            rvBadges.adapter = this.badgeAdapter

            previewAdapter = PreviewAdapter(context = this, data = it.app.previews)
            rvPreviews.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false)
            rvPreviews.adapter = this.previewAdapter
        }

        populateView()
    }

    private fun populateView(){
        detailsView?.let {
            toolbar_layout.title = it.app.name

            tvAppName.text = it.app.name
            tvAppProducer.text = it.app.producer
            tvAppPrice.text = getString(R.string.pricePattern, it.app.currency, it.app.price.toFloat())
            tvAppOriginalPrice.text = getString(R.string.pricePattern, it.app.currency, it.app.originalPrice.toFloat())
            tvAppOriginalPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            tvAppSize.text = getString(R.string.sizePattern, it.app.size)
            tvAppRating.text = it.app.ratingGrade.toString()
            tvAppRatingCount.text = getString(R.string.ratingPattern, it.app.ratingCount)
            tvAppDescription.text = it.app.details
            rbAppRating.rating = it.app.ratingGrade.toFloat()

            GlideApp.with(this)
                    .load(it.app.icon.url)
                    .placeholder(R.drawable.placeholder_300x300)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(ivAppIcon.ivAppIcon)

            GlideApp.with(this)
                    .load(it.app.banner.url)
                    .placeholder(R.drawable.placeholder_300x300)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(ivHeader)
        }
    }
}
