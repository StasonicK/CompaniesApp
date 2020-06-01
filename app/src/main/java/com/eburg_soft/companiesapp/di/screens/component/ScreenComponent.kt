package com.eburg_soft.companiesapp.di.screens.component

import com.eburg_soft.companiesapp.di.screens.modules.ScreenContextModule
import com.eburg_soft.companiesapp.di.screens.modules.ScreenModule
import com.eburg_soft.companiesapp.di.screens.scope.ScreensScope
import com.eburg_soft.companiesapp.ui.companies_list.CompaniesListFragment
import dagger.Subcomponent

@ScreensScope
@Subcomponent(modules = [ScreenContextModule::class, ScreenModule::class])
interface ScreenComponent {

    fun inject(companiesListFragment: CompaniesListFragment)
}