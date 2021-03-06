package com.eburg_soft.companiesapp.ui.companies_list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.eburg_soft.companiesapp.model.gateway.data.Company

class CompaniesDiffCallback : DiffUtil.ItemCallback<Company>() {
    override fun areItemsTheSame(oldItem: Company, newItem: Company): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Company, newItem: Company): Boolean {
        return oldItem == newItem
    }
}