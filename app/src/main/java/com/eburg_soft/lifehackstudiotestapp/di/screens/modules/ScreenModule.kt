package com.eburg_soft.lifehackstudiotestapp.di.screens.modules

import com.eburg_soft.lifehackstudiotestapp.di.screens.scope.ScreensScope
import com.eburg_soft.lifehackstudiotestapp.ui.companies_list.CompaniesListContract
import com.eburg_soft.lifehackstudiotestapp.ui.companies_list.CompaniesListPresenter
import dagger.Binds
import dagger.Module

@Module
interface ScreenModule {

    @Binds
    @ScreensScope
    fun provideCompanyListPresenter(companiesListPresenter: CompaniesListPresenter): CompaniesListContract.Presenter
}