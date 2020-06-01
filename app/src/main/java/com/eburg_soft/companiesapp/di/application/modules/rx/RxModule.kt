package com.eburg_soft.companiesapp.di.application.modules.rx

import com.eburg_soft.companiesapp.di.application.scope.AppScope
import com.eburg_soft.companiesapp.utils.MyRxUtils
import dagger.Module
import dagger.Provides

@Module
object RxModule {

    @JvmStatic
    @Provides
    @AppScope
    fun provideRxScheduler(): MyRxUtils.BaseSchedulerProvider = MyRxUtils.SchedulerProvider()
}