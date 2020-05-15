package com.eburg_soft.lifehackstudiotestapp.model.gateway

import com.eburg_soft.lifehackstudiotestapp.model.CompanyRes
import com.eburg_soft.lifehackstudiotestapp.ui.companies_list.adapter.CompaniesListAdapter.Company

object GatewayMapper {
    fun mapCompany(companyRes: CompanyRes): Company = Company(companyRes.id, companyRes.name, companyRes.img)

    fun mapCompaniesList(companyResList: List<CompanyRes>): List<Company> {
        val list = mutableListOf<Company>()
        for (i in companyResList.indices) {
            list.add(mapCompany(companyResList[i]))
        }
        return list
    }
}