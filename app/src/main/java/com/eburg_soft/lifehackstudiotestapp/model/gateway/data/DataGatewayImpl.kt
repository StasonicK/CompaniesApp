package com.eburg_soft.lifehackstudiotestapp.model.gateway

import com.eburg_soft.lifehackstudiotestapp.model.ApiClient
import com.eburg_soft.lifehackstudiotestapp.utils.MyRxUtils
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class DataGatewayImpl @Inject constructor(
    private val apiClient: ApiClient,
    private val scheduler: MyRxUtils.BaseSchedulerProvider
) : DataGateway {

    override fun loadData(): Completable {
        return Single.just(apiClient.getCompanies())

    }
}