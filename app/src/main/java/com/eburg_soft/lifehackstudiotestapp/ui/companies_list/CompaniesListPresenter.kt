package com.eburg_soft.lifehackstudiotestapp.ui.companies_list

import android.accounts.NetworkErrorException
import com.eburg_soft.lifehackstudiotestapp.model.gateway.data.DataGateway
import com.eburg_soft.lifehackstudiotestapp.ui.companies_list.adapter.CompaniesListAdapter.Company
import com.eburg_soft.lifehackstudiotestapp.utils.MyRxUtils
import java.net.UnknownHostException
import javax.inject.Inject

class CompaniesListPresenter @Inject constructor(
    private val dataGateway: DataGateway,
    private val scheduler: MyRxUtils.BaseSchedulerProvider
) : CompaniesListContract.Presenter() {

    override fun attach(view: CompaniesListContract.View) {
        this.view = view
    }

    override fun loadCompaniesList() {
        view?.showLoading()
        subscribe(
            dataGateway.loadData()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .subscribe({
                    view?.submitList(it)
                    view?.hideLoading()
                },
                    { error ->
                        when (error) {
                            is NetworkErrorException, is UnknownHostException -> {
                                view?.showNetworkErrorMessage()
                                view?.hideLoading()
                            }
                        }
                    }
                ))
    }

    override fun onCompanyClick(company: Company) {
        view?.openCompanyView(company)
    }
}