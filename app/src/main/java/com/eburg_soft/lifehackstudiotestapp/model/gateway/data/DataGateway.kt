package com.eburg_soft.lifehackstudiotestapp.model.gateway

import io.reactivex.Completable

interface DataGateway {
    fun loadData(): Completable
}