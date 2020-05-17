package com.eburg_soft.lifehackstudiotestapp.model

import io.reactivex.Single
import retrofit2.http.GET

interface ApiClient {

    @GET("/test_task/test.php")
    fun getCompanies(): Single<List<CompanyRes>>
}