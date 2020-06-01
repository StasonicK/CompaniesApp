package com.eburg_soft.lifehackstudiotestapp.di.application.component

import com.eburg_soft.lifehackstudiotestapp.common.App
import com.eburg_soft.lifehackstudiotestapp.di.application.modules.app.AppContextModule
import com.eburg_soft.lifehackstudiotestapp.di.application.modules.gateway.GatewayModule
import com.eburg_soft.lifehackstudiotestapp.di.application.modules.network.NetworkModule
import com.eburg_soft.lifehackstudiotestapp.di.application.modules.rx.RxModule
import com.eburg_soft.lifehackstudiotestapp.di.application.scope.AppScope
import com.eburg_soft.lifehackstudiotestapp.di.screens.component.ScreenComponent
import com.eburg_soft.lifehackstudiotestapp.di.screens.modules.ScreenContextModule
import dagger.Component

@AppScope
@Component(modules = [AppContextModule::class, NetworkModule::class, RxModule::class, GatewayModule::class])
interface AppComponent {

    fun createScreenComponent(screenContextModule: ScreenContextModule): ScreenComponent
    fun inject(app: App)
}