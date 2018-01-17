package br.com.renanbarbieri.bemobichallenge.presentation.ui

import android.support.v7.widget.RecyclerView
import br.com.renanbarbieri.bemobichallenge.R
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

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