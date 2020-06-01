package com.eburg_soft.companiesapp.di.application.component

import com.eburg_soft.companiesapp.common.App
import com.eburg_soft.companiesapp.di.application.modules.app.AppContextModule
import com.eburg_soft.companiesapp.di.application.modules.gateway.GatewayModule
import com.eburg_soft.companiesapp.di.application.modules.network.NetworkModule
import com.eburg_soft.companiesapp.di.application.modules.rx.RxModule
import com.eburg_soft.companiesapp.di.application.scope.AppScope
import com.eburg_soft.companiesapp.di.screens.component.ScreenComponent
import com.eburg_soft.companiesapp.di.screens.modules.ScreenContextModule
import dagger.Component

@AppScope
@Component(modules = [AppContextModule::class, NetworkModule::class, RxModule::class, GatewayModule::class])
interface AppComponent {

    fun createScreenComponent(screenContextModule: ScreenContextModule): ScreenComponent
    fun inject(app: App)
}