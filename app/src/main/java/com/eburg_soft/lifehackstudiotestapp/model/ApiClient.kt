package com.eburg_soft.lifehackstudiotestapp.model

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {


    @GET("test_task/test.php/")
    fun getCompanies(): Single<List<CompanyRes>>

    @GET("/http://megakohz.bget.ru/test_task/test.php?")
    fun getCompanyById(@Query("id") id: String): Single<List<CompanyRes>>
}