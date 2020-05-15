package com.eburg_soft.lifehackstudiotestapp.model.gateway.data

import com.eburg_soft.lifehackstudiotestapp.ui.companies_list.adapter.CompaniesListAdapter.Company
import io.reactivex.Completable
import io.reactivex.Single

interface DataGateway {
    fun loadData(): Single<List<Company>>
}