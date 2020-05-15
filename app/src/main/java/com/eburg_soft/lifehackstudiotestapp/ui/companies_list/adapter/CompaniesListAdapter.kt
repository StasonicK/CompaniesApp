package com.eburg_soft.lifehackstudiotestapp.ui.companise_list.adapter

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eburg_soft.lifehackstudiotestapp.R
import com.eburg_soft.lifehackstudiotestapp.ui.companise_list.adapter.CompaniesListAdapter.CompaniesViewHolder
import com.eburg_soft.lifehackstudiotestapp.ui.companise_list.adapter.CompaniesListAdapter.Company
import kotlinx.android.parcel.Parcelize

class CompaniesListAdapter(val listener: OnCompanyItemClickListener? = null) :
    ListAdapter<Company, CompaniesViewHolder>(CompaniesDiffCallback()) {


    interface OnCompanyItemClickListener {
        fun onCompanyClick(company: Company)
    }

    inner class CompaniesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var id: String = ""
        var name: String = ""
        var image: String = ""

        fun bind(item: Company) {

            let {
                itemView.`@+id/tv_id_text`.text = item.id

                id = item.id
                name = item.name
                image = item.image

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
    data class Company(val id: String, val name: String, val image: String) : Parcelable {
    }
}