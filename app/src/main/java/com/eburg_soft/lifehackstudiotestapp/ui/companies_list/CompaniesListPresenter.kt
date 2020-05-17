package com.eburg_soft.lifehackstudiotestapp.ui.companies_list

import android.accounts.NetworkErrorException
import android.util.Log
import com.eburg_soft.lifehackstudiotestapp.model.gateway.data.Company
import com.eburg_soft.lifehackstudiotestapp.model.gateway.data.DataGateway
import com.eburg_soft.lifehackstudiotestapp.utils.MyRxUtils
import java.net.UnknownHostException
import javax.inject.Inject

class CompaniesListPresenter @Inject constructor(
    private val dataGateway: DataGateway,
    private val scheduler: MyRxUtils.BaseSchedulerProvider
) : CompaniesListContract.Presenter() {

    companion object {
        const val TAG = "CompaniesListPresenter"
    }

    override fun attach(view: CompaniesListContract.View) {
        this.view = view
    }

    override fun loadCompaniesList() {
        view?.showLoading()
        subscribe(
            dataGateway.loadData()
                .observeOn(scheduler.ui())
                .subscribe({
                    view?.submitList(it)
                    view?.hideLoading()
                    Log.d(TAG, "loadCompaniesList is success")
                },
                    { error ->
                        when (error) {
                            is NetworkErrorException, is UnknownHostException -> {
                                view?.showNetworkErrorMessage()
                                view?.hideLoading()
                                Log.d(TAG, "loadCompaniesList is fault, showNetworkErrorMessage()")
                            }
                            else -> {
                                view?.showErrorMessage(error.message.toString())
                                error.printStackTrace()
                                Log.d(TAG, "loadCompaniesList is fault, showErrorMessage()")
                            }
                        }
                    }
                ))
    }

    override fun onCompanyClick(company: Company) {
        view?.openCompanyView(company)
    }
}