package com.eburg_soft.lifehackstudiotestapp.ui.companies_list.adapter

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eburg_soft.lifehackstudiotestapp.R
import com.eburg_soft.lifehackstudiotestapp.ui.companies_list.adapter.CompaniesListAdapter.CompaniesViewHolder
import com.eburg_soft.lifehackstudiotestapp.ui.companies_list.adapter.CompaniesListAdapter.Company
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.recycler_view_item.view.tv_name_item

class CompaniesListAdapter(val listener: OnCompanyItemClickListener? = null) :
    ListAdapter<Company, CompaniesViewHolder>(CompaniesDiffCallback()) {

    interface OnCompanyItemClickListener {
        fun onCompanyClick(company: Company)
    }

    inner class CompaniesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var id: String = ""
        var name: String = ""
        var imageUrl: String = ""

        fun bind(item: Company) {

            apply {
                itemView.tv_name_item.text = item.name

                id = item.id
                name = item.name
                imageUrl = item.imageUrl

                itemView.setOnClickListener { listener?.onCompanyClick(item) }
            }
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

    @Parcelize
    data class Company(val id: String, val name: String, val imageUrl: String) : Parcelable {
    }
}