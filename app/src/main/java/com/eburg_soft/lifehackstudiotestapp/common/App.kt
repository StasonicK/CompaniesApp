package com.eburg_soft.lifehackstudiotestapp.common

import android.app.Application
import com.eburg_soft.lifehackstudiotestapp.di.application.component.AppComponent
import com.eburg_soft.lifehackstudiotestapp.di.application.component.DaggerAppComponent
import com.eburg_soft.lifehackstudiotestapp.di.application.modules.app.AppContextModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appContextModule(AppContextModule(applicationContext))
            .build()
    }

}