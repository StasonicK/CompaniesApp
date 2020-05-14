package ru.skillbranch.lifehackstudiotestapp.di.application.modules.rx

import dagger.Module
import dagger.Provides
import ru.skillbranch.lifehackstudiotestapp.di.application.scope.AppScope
import ru.skillbranch.lifehackstudiotestapp.utils.MyRxUtils

@Module
object RxModule {

    @JvmStatic
    @Provides
    @AppScope
    fun provideRxScheduler(): MyRxUtils.BaseSchedulerProvider = MyRxUtils.SchedulerProvider()
}