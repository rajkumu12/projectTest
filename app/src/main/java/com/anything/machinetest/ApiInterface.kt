package com.anything.machinetest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("v2/everything")
    fun getTasks(@Query("domains") domains: String?,@Query("apiKey") apiKey:String): Call<News>


}