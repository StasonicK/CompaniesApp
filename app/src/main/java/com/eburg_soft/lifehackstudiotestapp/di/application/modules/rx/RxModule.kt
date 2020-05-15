package com.eburg_soft.lifehackstudiotestapp.di.application.modules.rx

import com.eburg_soft.lifehackstudiotestapp.di.application.scope.AppScope
import com.eburg_soft.lifehackstudiotestapp.utils.MyRxUtils
import dagger.Module
import dagger.Provides

@Module
object RxModule {

    @JvmStatic
    @Provides
    @AppScope
    fun provideRxScheduler(): MyRxUtils.BaseSchedulerProvider = MyRxUtils.SchedulerProvider()
}