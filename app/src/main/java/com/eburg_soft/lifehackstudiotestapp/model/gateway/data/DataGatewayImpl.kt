package com.eburg_soft.lifehackstudiotestapp.model.gateway.data

import com.eburg_soft.lifehackstudiotestapp.model.ApiClient
import com.eburg_soft.lifehackstudiotestapp.model.gateway.GatewayMapper
import com.eburg_soft.lifehackstudiotestapp.utils.MyRxUtils
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