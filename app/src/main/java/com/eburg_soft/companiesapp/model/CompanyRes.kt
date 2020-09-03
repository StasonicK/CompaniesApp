package com.eburg_soft.companiesapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CompanyRes(
    var id: String,
    var name: String,
    var img: String
) : Parcelable
