package com.eburg_soft.companiesapp.model.gateway.data

import io.reactivex.Single

interface DataGateway {
    fun loadData(): Single<List<Company>>
}