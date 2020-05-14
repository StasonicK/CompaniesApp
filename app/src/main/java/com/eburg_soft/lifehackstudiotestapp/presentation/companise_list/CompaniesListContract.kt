package com.eburg_soft.lifehackstudiotestapp.presentation.companise_list

import com.eburg_soft.lifehackstudiotestapp.presentation.base.BaseContract

interface CompaniesListContract {

    interface View : BaseContract.View {

    }

    abstract class Presenter : BaseContract.Presenter<View>() {

    }
}