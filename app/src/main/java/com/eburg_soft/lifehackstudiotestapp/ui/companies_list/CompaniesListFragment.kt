package com.eburg_soft.lifehackstudiotestapp.ui.companise_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.eburg_soft.lifehackstudiotestapp.R
import com.eburg_soft.lifehackstudiotestapp.model.CompanyRes

class CompaniesListFragment : Fragment(), CompaniesListContract.View {

    companion object {
        const val TAG = "CompaniesListFragment"

        fun getNewInstance(): CompaniesListFragment {
            val bundle = Bundle()
            val fragment = CompaniesListFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_companies_list, container, false)
    }

    override fun openCompanyView(companyRes: CompanyRes) {
        TODO("Not yet implemented")
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }
}
