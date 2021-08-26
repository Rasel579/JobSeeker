package com.test_app.jobseeker.ui

import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.test_app.jobseeker.R
import com.test_app.jobseeker.navigation.SearchScreen
import com.test_app.jobseeker.ui.daggerAbs.AbsActivity
import javax.inject.Inject

class MainActivity : AbsActivity(R.layout.activity_main) {
    private val navigator = AppNavigator(this, R.id.container)

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?: router.navigateTo(SearchScreen.create())
    }

    override fun onResumeFragments() {
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}