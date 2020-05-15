package com.eburg_soft.lifehackstudiotestapp.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.eburg_soft.lifehackstudiotestapp.R
import com.eburg_soft.lifehackstudiotestapp.R.layout
import com.eburg_soft.lifehackstudiotestapp.ui.companies_list.CompaniesListFragment
import kotlinx.android.synthetic.main.toolbar.toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        setSupportActionBar(toolbar)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(
                    R.id.frame_container,
                    CompaniesListFragment.getNewInstance(),
                    CompaniesListFragment.TAG + " created"
                )
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        fragmentManager.findFragmentById(R.id.frame_container)
        if (fragmentManager.backStackEntryCount > 1) {
            fragmentManager.popBackStack()
        } else finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
