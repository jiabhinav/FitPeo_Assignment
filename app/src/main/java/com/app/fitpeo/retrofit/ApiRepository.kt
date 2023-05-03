package com.app.fitpeo.retrofit


import javax.inject.Inject

    class ApiRepository @Inject constructor(
    private val apiServices: ApiServices)
{
   suspend fun android_dashboard() = apiServices.android_dashboard()



}