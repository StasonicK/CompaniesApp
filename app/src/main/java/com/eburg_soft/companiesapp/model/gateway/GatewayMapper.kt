package com.eburg_soft.companiesapp.model.gateway

import com.eburg_soft.companiesapp.model.CompanyRes
import com.eburg_soft.companiesapp.model.gateway.data.Company

object GatewayMapper {
    fun mapCompany(companyRes: CompanyRes) = Company(companyRes.id, companyRes.name, companyRes.img)

    fun mapCompaniesList(companyResList: List<CompanyRes>): List<Company> {
        val list = mutableListOf<Company>()
        companyResList.forEach {
//            Log.d("GatewayMapper", "companyRes: $it")
            list.add(mapCompany(it))
        }
//        Log.d("GatewayMapper", "companies list: $list}")
        return list
    }
}