package com.eburg_soft.lifehackstudiotestapp.di.application.component

import com.eburg_soft.lifehackstudiotestapp.common.App
import com.eburg_soft.lifehackstudiotestapp.di.application.modules.app.AppContextModule
import com.eburg_soft.lifehackstudiotestapp.di.application.modules.network.NetworkModule
import com.eburg_soft.lifehackstudiotestapp.di.application.modules.rx.RxModule
import com.eburg_soft.lifehackstudiotestapp.di.application.scope.AppScope
import dagger.Component

@AppScope
@Component(modules = [AppContextModule::class, NetworkModule::class, RxModule::class])
interface AppComponent {
//fun createScreenComponent()
    fun inject(app:App)
}