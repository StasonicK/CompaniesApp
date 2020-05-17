package com.eburg_soft.lifehackstudiotestapp.ui.company_page

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.eburg_soft.lifehackstudiotestapp.R
import com.eburg_soft.lifehackstudiotestapp.common.Constants.BASE_URL
import com.eburg_soft.lifehackstudiotestapp.model.gateway.data.Company
import com.eburg_soft.lifehackstudiotestapp.ui.MainActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.progressbar
import kotlinx.android.synthetic.main.fragment_company.iv_image
import kotlinx.android.synthetic.main.fragment_company.tv_id
import kotlinx.android.synthetic.main.fragment_company.tv_name

class CompanyFragment() : Fragment(R.layout.fragment_company) {

    private var company: Company? = null

    companion object {
        const val TAG = "CompanyFragment"

        private const val COMPANY = "Company"

        @JvmStatic
        fun getNewInstance(company: Company) = CompanyFragment().apply {
            arguments = Bundle().apply { putParcelable(COMPANY, company) }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        company = requireArguments().getParcelable(COMPANY) as Company?
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().progressbar.visibility = View.INVISIBLE
        bindViews()
    }

    override fun onStart() {
        super.onStart()
        setupToolbar()
    }

    private fun setupToolbar() {
        val actionBar: ActionBar? = (activity as MainActivity).supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)
        actionBar?.title = ""
    }

    private fun bindViews() {
        tv_id.text = company?.id ?: ""
        tv_name.text = company?.name ?: ""
        Picasso.get().load(BASE_URL + company?.imageUrl)
            .placeholder(R.drawable.image_placeholder)
            .centerCrop()
            .resize(100, 100)
            .error(R.drawable.image_error)
            .into(iv_image)

        Log.d(TAG, "bindViews: id ${company?.id}, name ${company?.name}, url ${company?.imageUrl}")
    }
}