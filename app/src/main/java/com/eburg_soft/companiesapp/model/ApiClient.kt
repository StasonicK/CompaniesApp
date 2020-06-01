package com.eburg_soft.companiesapp.model

import io.reactivex.Single
import retrofit2.http.GET

interface ApiClient {

    @GET("/test_task/test.php")
    fun getCompanies(): Single<List<CompanyRes>>
}