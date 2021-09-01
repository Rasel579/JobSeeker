package com.test_app.jobseeker.ui

import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.test_app.jobseeker.R
import com.test_app.jobseeker.databinding.ActivityMainBinding
import com.test_app.jobseeker.navigation.SearchScreen
import com.test_app.jobseeker.presenters.MainPresenter
import com.test_app.jobseeker.ui.daggerAbs.AbsActivity
import com.test_app.jobseeker.view.MainView
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class MainActivity : AbsActivity(R.layout.activity_main), MainView {
    private val navigator = AppNavigator(this, R.id.container)
    private val viewBinding: ActivityMainBinding by viewBinding()

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    private val presenter by moxyPresenter {
        MainPresenter(
            router
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?: router.newRootChain(SearchScreen.create())
    }

    override fun onResumeFragments() {
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        presenter.onBackButtonPressed()
    }

    override fun setBackButtonListener() {
        viewBinding.toolBar.setNavigationOnClickListener {
            presenter.onBackButtonPressed()
        }
    }
}