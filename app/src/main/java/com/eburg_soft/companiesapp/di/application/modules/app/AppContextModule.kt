package com.eburg_soft.companiesapp.di.application.modules.app

import android.content.Context
import com.eburg_soft.companiesapp.di.application.scope.AppScope
import dagger.Module
import dagger.Provides

@Module
class AppContextModule(private val context: Context) {

    @Provides
    @AppContext
    @AppScope
    fun provideContext(): Context = context
}