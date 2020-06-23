package com.eburg_soft.companiesapp.ui.companies_list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eburg_soft.companiesapp.R
import com.eburg_soft.companiesapp.model.gateway.data.Company
import com.eburg_soft.companiesapp.ui.companies_list.adapter.CompaniesListAdapter.CompaniesViewHolder
import kotlinx.android.synthetic.main.recycler_view_item.view.tv_name_item

class CompaniesListAdapter
    (val listener: OnCompanyItemClickListener? = null) :
    ListAdapter<Company, CompaniesViewHolder>(CompaniesDiffCallback()) {

    interface OnCompanyItemClickListener {
        fun onCompanyClick(company: Company)
    }

    inner class CompaniesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: Company) {
            itemView.tv_name_item.text = item.name

            itemView.setOnClickListener { listener?.onCompanyClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompaniesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
        return CompaniesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CompaniesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}