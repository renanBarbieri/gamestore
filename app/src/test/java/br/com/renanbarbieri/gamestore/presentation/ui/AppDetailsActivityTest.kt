package br.com.renanbarbieri.gamestore.presentation.ui

import android.support.v7.widget.RecyclerView
import br.com.renanbarbieri.gamestore.R
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import android.content.Intent
import br.com.renanbarbieri.gamestore.presentation.model.AppModel
import br.com.renanbarbieri.gamestore.presentation.model.BadgeModel
import br.com.renanbarbieri.gamestore.presentation.model.CategoryModel
import br.com.renanbarbieri.gamestore.presentation.model.ImageModel
import org.robolectric.shadows.ShadowApplication


/**
 */
@RunWith(RobolectricTestRunner::class)
class AppDetailsActivityTest {

    @Test
    fun onInitShouldShouldSetupDetailsView() {
        val detailsActivity = getGenericActivityWithArgument()
        assertNotNull(detailsActivity.detailsView)
    }

    @Test
    fun onCreateShouldSetupAppModel(){
        val detailsActivity = getGenericActivityWithArgument()

        assertNotNull(detailsActivity.detailsView)
        assertNotNull(detailsActivity.detailsView!!.app)
    }

    @Test
    fun onCreateShouldInflateBadgeRecyclerView() {
        val detailsActivity = getGenericActivityWithArgument()
        val rvBadges = detailsActivity.findViewById<RecyclerView>(R.id.rvBadges)
        assertNotNull(rvBadges)
    }

    @Test
    fun onCreateShouldSetupBadgeRecyclerView() {
        val detailsActivity = getGenericActivityWithArgument()
        val rvBadges = detailsActivity.findViewById<RecyclerView>(R.id.rvBadges)
        assertNotNull(rvBadges.adapter)
    }

    @Test
    fun onCreateShouldInflatePreviewsRecyclerView() {
        val detailsActivity = getGenericActivityWithArgument()
        val rvPreviews = detailsActivity.findViewById<RecyclerView>(R.id.rvPreviews)
        assertNotNull(rvPreviews)
    }

    @Test
    fun onCreateShouldSetupPreviewsRecyclerView() {
        val detailsActivity = getGenericActivityWithArgument()
        val rvPreviews = detailsActivity.findViewById<RecyclerView>(R.id.rvPreviews)
        assertNotNull(rvPreviews.adapter)
    }

    private fun getGenericOpenActivityArgument() = AppModel(
            id = "id",
            name = "nome",
            price = 0.0,
            originalPrice = 3.0,
            currency = "R$",
            category = CategoryModel("Categoria"),
            banner = ImageModel("http://google.com"),
            icon = ImageModel("http://google.com"),
            producer = "Produtor",
            details = "Detalhes do app",
            previews = arrayListOf(ImageModel("http://google.com")),
            size = 10,
            badges = arrayListOf(BadgeModel("http://google.com", "lorem ipsum")),
            ratingCount = 1203,
            ratingGrade = 3.3
    )

    private fun getGenericActivityWithArgument(): AppDetailsActivity{
        val openDetailsActivityIntent = Intent(ShadowApplication.getInstance().applicationContext, AppDetailsActivity::class.java)
        openDetailsActivityIntent.putExtra(AppDetailsActivity.ARG_APP_SELECTED, getGenericOpenActivityArgument())
        return Robolectric.buildActivity(AppDetailsActivity::class.java, openDetailsActivityIntent).create().get() as AppDetailsActivity
    }

}