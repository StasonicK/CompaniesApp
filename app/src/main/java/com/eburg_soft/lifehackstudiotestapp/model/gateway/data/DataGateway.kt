package com.eburg_soft.lifehackstudiotestapp.model.gateway.data

import io.reactivex.Single

interface DataGateway {
    fun loadData(): Single<List<Company>>
}