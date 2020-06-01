package com.eburg_soft.lifehackstudiotestapp.ui.companies_list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.eburg_soft.lifehackstudiotestapp.R
import com.eburg_soft.lifehackstudiotestapp.model.gateway.data.Company
import com.eburg_soft.lifehackstudiotestapp.ui.MainActivity
import com.eburg_soft.lifehackstudiotestapp.ui.companies_list.adapter.CompaniesListAdapter
import com.eburg_soft.lifehackstudiotestapp.ui.company_page.CompanyFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.progressbar
import kotlinx.android.synthetic.main.fragment_companies_list.recycler_companies
import javax.inject.Inject

class CompaniesListFragment : Fragment(R.layout.fragment_companies_list), CompaniesListContract.View,
    CompaniesListAdapter.OnCompanyItemClickListener {

    @Inject
    lateinit var presenter: CompaniesListContract.Presenter

    private val listAdapter = CompaniesListAdapter(this)

    companion object {
        const val TAG = "CompaniesListFragment"

        @JvmStatic
        fun getNewInstance(): CompaniesListFragment {
            val bundle = Bundle()
            val fragment = CompaniesListFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_companies.adapter = listAdapter
        recycler_companies.layoutManager = LinearLayoutManager(context)
        recycler_companies.addItemDecoration(
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        )
        setHomeButtonInvisible()
        Log.d(TAG, "onViewCreated")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getScreenComponent(requireContext()).inject(this)

        retainInstance = true
        Log.d(TAG, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        presenter.attach(this)
        presenter.loadCompaniesList()
        Log.d(TAG, "onStart")
    }

    override fun onStop() {
        super.onStop()
        presenter.detach()
        Log.d(TAG, "onStop")
    }

    override fun openCompanyView(company: Company) {
        requireActivity().supportFragmentManager.let {
            if (it.findFragmentByTag(CompanyFragment.TAG) == null) {
                it.beginTransaction()
                    .replace(R.id.frame_container, CompanyFragment.getNewInstance(company), CompanyFragment.TAG)
                    .addToBackStack(null)
                    .commit()
            }
        }
        Log.d(TAG, "openCompanyView")
    }

    override fun showLoading() {
        requireActivity().progressbar.visibility = View.VISIBLE
        Log.d(TAG, "showLoading")
    }

    override fun hideLoading() {
        requireActivity().progressbar.visibility = View.INVISIBLE
        Log.d(TAG, "hideLoading")
    }

    override fun showNetworkErrorMessage() {
        Snackbar.make(recycler_companies, "Нет подключения к сети", Snackbar.LENGTH_LONG).show()
        Log.d(TAG, "showNetworkErrorMessage")
    }

    override fun onCompanyClick(company: Company) {
        presenter.onCompanyClick(company)
        Log.d(TAG, "clicked on company id: $company.id")
    }

    override fun submitList(list: List<Company>) {
        listAdapter.submitList(list)
        Log.d(TAG, "list submitted")
    }

    override fun showErrorMessage(error: String) {
        Snackbar.make(recycler_companies, error, Snackbar.LENGTH_LONG).show()
        Log.d(TAG, "showErrorMessage")
    }

    private fun setHomeButtonInvisible() {
        val actionBar: ActionBar? = (activity as MainActivity).supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(false)
        actionBar?.setDisplayShowHomeEnabled(false)
    }
}
