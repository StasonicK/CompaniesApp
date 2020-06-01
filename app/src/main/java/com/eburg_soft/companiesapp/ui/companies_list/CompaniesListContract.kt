package com.eburg_soft.lifehackstudiotestapp.ui.companies_list

import com.eburg_soft.lifehackstudiotestapp.model.gateway.data.Company
import com.eburg_soft.lifehackstudiotestapp.ui.base.BaseContract

interface CompaniesListContract {

    interface View : BaseContract.View {
        fun openCompanyView(company: Company)
        fun showLoading()
        fun hideLoading()
        fun showNetworkErrorMessage()
        fun submitList(list: List<Company>)
        fun showErrorMessage(error: String)
    }

    abstract class Presenter : BaseContract.Presenter<View>() {
        abstract fun loadCompaniesList()
        abstract fun onCompanyClick(company: Company)
    }
}