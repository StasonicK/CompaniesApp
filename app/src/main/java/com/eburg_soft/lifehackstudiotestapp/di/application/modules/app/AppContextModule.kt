package com.eburg_soft.lifehackstudiotestapp.di.application.modules.app

import android.content.Context
import dagger.Module
import dagger.Provides
import com.eburg_soft.lifehackstudiotestapp.di.application.scope.AppScope

@Module
class AppContextModule(private val context: Context) {

    @Provides
    @AppContext
    @AppScope
    fun provideContext(): Context = context
}