package com.eburg_soft.lifehackstudiotestapp.ui.companies_list

import com.eburg_soft.lifehackstudiotestapp.ui.base.BaseContract
import com.eburg_soft.lifehackstudiotestapp.ui.companies_list.adapter.CompaniesListAdapter.Company

interface CompaniesListContract {

    interface View : BaseContract.View {
        fun openCompanyView(company: Company)
        fun showLoading()
        fun hideLoading()
        fun showNetworkErrorMessage()
        fun submitList(list: List<Company>)
    }

    abstract class Presenter : BaseContract.Presenter<View>() {
        abstract fun loadCompaniesList()
        abstract fun onCompanyClick(company: Company)
    }
}