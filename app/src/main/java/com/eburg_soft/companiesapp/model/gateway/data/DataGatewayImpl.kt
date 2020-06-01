package com.eburg_soft.companiesapp.model.gateway.data

import com.eburg_soft.companiesapp.model.ApiClient
import com.eburg_soft.companiesapp.model.gateway.GatewayMapper
import com.eburg_soft.companiesapp.utils.MyRxUtils
import io.reactivex.Single
import javax.inject.Inject

class DataGatewayImpl @Inject constructor(
    private val apiClient: ApiClient,
    private val scheduler: MyRxUtils.BaseSchedulerProvider
) : DataGateway {

    override fun loadData(): Single<List<Company>> {
        return apiClient.getCompanies()
            .map { t -> GatewayMapper.mapCompaniesList(t) }
            .subscribeOn(scheduler.io())
    }
}