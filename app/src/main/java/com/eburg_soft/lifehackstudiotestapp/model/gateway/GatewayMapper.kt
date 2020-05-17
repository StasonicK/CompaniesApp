package com.eburg_soft.lifehackstudiotestapp.model.gateway

import android.util.Log
import com.eburg_soft.lifehackstudiotestapp.model.CompanyRes
import com.eburg_soft.lifehackstudiotestapp.ui.companies_list.adapter.CompaniesListAdapter.Company

object GatewayMapper {
    fun mapCompany(companyRes: CompanyRes): Company = Company(companyRes.id, companyRes.name, companyRes.img)

    fun mapCompaniesList(companyResList: List<CompanyRes>): List<Company> {
        val list = mutableListOf<Company>()
        for (i in companyResList.indices) {

            Log.d("GatewayMapper", "companyRes: ${companyResList[i]}")
            list.add(mapCompany(companyResList[i]))
        }
        Log.d("GatewayMapper", "companies list: ${list.toString()}")
        return list
    }
}