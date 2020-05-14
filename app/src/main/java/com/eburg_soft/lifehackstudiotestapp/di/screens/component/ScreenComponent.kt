package com.eburg_soft.lifehackstudiotestapp.di.screens.component

import com.eburg_soft.lifehackstudiotestapp.di.screens.modules.ScreenContextModule
import com.eburg_soft.lifehackstudiotestapp.di.screens.scope.ScreensScope
import com.eburg_soft.lifehackstudiotestapp.presentation.companise_list.CompaniesListFragment
import dagger.Component
@ScreensScope
@Component(modules = [ScreenContextModule::class])
interface ScreenComponent {
    fun inject(companiesListFragment: CompaniesListFragment)
}