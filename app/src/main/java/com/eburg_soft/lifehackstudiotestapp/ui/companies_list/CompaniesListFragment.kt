package com.eburg_soft.lifehackstudiotestapp.ui.companies_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.eburg_soft.lifehackstudiotestapp.R
import com.eburg_soft.lifehackstudiotestapp.ui.MainActivity
import com.eburg_soft.lifehackstudiotestapp.ui.companies_list.adapter.CompaniesListAdapter
import com.eburg_soft.lifehackstudiotestapp.ui.companies_list.adapter.CompaniesListAdapter.Company
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
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getScreenComponent(requireContext()).inject(this)

        retainInstance = true
        presenter.loadCompaniesList()
    }

    override fun onStart() {
        super.onStart()
        presenter.attach(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detach()
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
    }

    override fun showLoading() {
        requireActivity().progressbar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        requireActivity().progressbar.visibility = View.INVISIBLE
    }

    override fun showNetworkErrorMessage() {
        Snackbar.make(recycler_companies, "Нет подключения к сети", Snackbar.LENGTH_LONG).show()
    }

    override fun onCompanyClick(company: Company) {
        presenter.onCompanyClick(company)
    }

    override fun submitList(list: List<Company>) {
        listAdapter.submitList(list)
    }

    private fun setHomeButtonInvisible() {
        val actionBar: ActionBar? = (activity as MainActivity).supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(false)
        actionBar?.setDisplayShowHomeEnabled(false)
    }
}
