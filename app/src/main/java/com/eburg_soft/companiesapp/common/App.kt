package com.eburg_soft.companiesapp.common

import android.app.Application
import com.eburg_soft.companiesapp.di.application.component.AppComponent
import com.eburg_soft.companiesapp.di.application.component.DaggerAppComponent
import com.eburg_soft.companiesapp.di.application.modules.app.AppContextModule

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