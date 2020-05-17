package com.eburg_soft.lifehackstudiotestapp.ui.companies_list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eburg_soft.lifehackstudiotestapp.R
import com.eburg_soft.lifehackstudiotestapp.model.gateway.data.Company
import kotlinx.android.synthetic.main.recycler_view_item.view.tv_name_item

class CompaniesRecyclerViewAdapter(private val listener: OnCompanyItemClickListener? = null) :
    RecyclerView.Adapter<CompaniesRecyclerViewAdapter.CompanyViewHolder>() {

    interface OnCompanyItemClickListener {
        fun onCompanyClick(company: Company)
    }

    private val companyList = mutableListOf<Company>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
        return CompanyViewHolder(view = view)
    }

    override fun getItemCount(): Int = companyList.size

    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
        val item = companyList[position]
        holder.bind(company = item, listener = this.listener!!)
    }

    fun updateHistoryList(newHistory: List<Company>) {
        companyList.clear()
        companyList.addAll(newHistory)
        notifyDataSetChanged()
    }

    inner class CompanyViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(company: Company, listener: OnCompanyItemClickListener) {
            val item = Company()

            itemView.tv_name_item.text = company.name

            item.id = company.id
            item.name = company.name
            item.imageUrl = company.imageUrl

            itemView.setOnClickListener { listener.onCompanyClick(item) }
        }
    }
}