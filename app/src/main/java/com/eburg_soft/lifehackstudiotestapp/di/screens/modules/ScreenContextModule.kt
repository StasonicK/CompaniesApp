package com.eburg_soft.lifehackstudiotestapp.di.screens.modules

import android.content.Context
import com.eburg_soft.lifehackstudiotestapp.di.screens.component.ScreenContext
import com.eburg_soft.lifehackstudiotestapp.di.screens.scope.ScreensScope
import dagger.Module
import dagger.Provides

@Module
class ScreenContextModule(private val context: Context) {

    @Provides
    @ScreensScope
    @ScreenContext
    fun provideContext(): Context = context
}