package br.com.renanbarbieri.gamestore.presentation.ui

import android.support.v7.widget.RecyclerView
import br.com.renanbarbieri.gamestore.R
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

/**
 *
 */
@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    @Test
    fun onInitShouldSetupMainView(){
        val mainActivity = Robolectric.setupActivity(MainActivity::class.java) as MainActivity
        assertNotNull(mainActivity.mainView)
    }

    @Test
    fun onCreateShouldInflateRecyclerView() {
        val mainActivity = Robolectric.setupActivity(MainActivity::class.java) as MainActivity
        val rvApps = mainActivity.findViewById<RecyclerView>(R.id.rvApps)
        assertNotNull(rvApps)
    }

    @Test
    fun onCreateShouldSetupRecyclerView() {
        val mainActivity = Robolectric.setupActivity(MainActivity::class.java) as MainActivity
        val rvApps = mainActivity.findViewById<RecyclerView>(R.id.rvApps)
        assertNotNull(rvApps.adapter)
    }

}