package ru.skillbranch.lifehackstudiotestapp.di.application.modules.app

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.skillbranch.lifehackstudiotestapp.di.application.scope.AppScope

@Module
class AppContextModule(private val context: Context) {

    @Provides
    @AppContext
    @AppScope
    fun provideContext(): Context = context
}