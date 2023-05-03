package com.app.fitpeo.retrofit

import com.app.fitpeo.model.*
import retrofit2.Response
import retrofit2.http.*

interface ApiServices {


    @GET("photos")
     suspend fun android_dashboard(): Response<List<ModelPhoto>>


}