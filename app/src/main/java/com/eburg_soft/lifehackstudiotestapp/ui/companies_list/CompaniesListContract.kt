package com.eburg_soft.lifehackstudiotestapp.ui.companise_list

import com.eburg_soft.lifehackstudiotestapp.model.CompanyRes
import com.eburg_soft.lifehackstudiotestapp.ui.base.BaseContract

interface CompaniesListContract {

    interface View : BaseContract.View {
        fun openCompanyView(companyRes: CompanyRes)
        fun showLoading()
        fun hideLoading()
    }

    abstract class Presenter : BaseContract.Presenter<View>() {
        abstract fun loadCompaniesList()
    }
}