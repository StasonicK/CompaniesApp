package com.eburg_soft.lifehackstudiotestapp.di.application.modules.app

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class AppContext {
}