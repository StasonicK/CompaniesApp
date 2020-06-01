package com.eburg_soft.companiesapp.di.application.modules.gateway

import com.eburg_soft.companiesapp.di.application.scope.AppScope
import com.eburg_soft.companiesapp.model.gateway.data.DataGateway
import com.eburg_soft.companiesapp.model.gateway.data.DataGatewayImpl
import dagger.Binds
import dagger.Module

@Module
abstract class GatewayModule {

    @Binds
    @AppScope
    abstract fun provideGateway(dataGateway: DataGatewayImpl): DataGateway
}