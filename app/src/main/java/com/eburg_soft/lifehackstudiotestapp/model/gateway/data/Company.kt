package com.eburg_soft.lifehackstudiotestapp.model.gateway.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Company(var id: String = "", var name: String = "", var imageUrl: String = "") : Parcelable {
}