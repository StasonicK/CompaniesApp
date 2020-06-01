package com.eburg_soft.lifehackstudiotestapp.di.screens.component

import com.eburg_soft.lifehackstudiotestapp.di.screens.modules.ScreenContextModule
import com.eburg_soft.lifehackstudiotestapp.di.screens.modules.ScreenModule
import com.eburg_soft.lifehackstudiotestapp.di.screens.scope.ScreensScope
import com.eburg_soft.lifehackstudiotestapp.ui.companies_list.CompaniesListFragment
import dagger.Subcomponent

@ScreensScope
@Subcomponent(modules = [ScreenContextModule::class, ScreenModule::class])
interface ScreenComponent {

    fun inject(companiesListFragment: CompaniesListFragment)
}