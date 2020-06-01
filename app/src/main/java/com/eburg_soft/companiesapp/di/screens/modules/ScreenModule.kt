package com.eburg_soft.companiesapp.di.screens.modules

import com.eburg_soft.companiesapp.di.screens.scope.ScreensScope
import com.eburg_soft.companiesapp.ui.companies_list.CompaniesListContract
import com.eburg_soft.companiesapp.ui.companies_list.CompaniesListPresenter
import dagger.Binds
import dagger.Module

@Module
interface ScreenModule {

    @Binds
    @ScreensScope
    fun provideCompanyListPresenter(companiesListPresenter: CompaniesListPresenter): CompaniesListContract.Presenter
}