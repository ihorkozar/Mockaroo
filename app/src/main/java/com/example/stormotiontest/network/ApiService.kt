package com.example.stormotiontest.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://my.api.mockaroo.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @GET("test.json?key=6e40d570")
    suspend fun getProperties(): List<Property>
    /*@GET("realestate")
    suspend fun getProperties(@Query("q") type: String): List<Property>*/
}

object Api{
    val RETROFIT_SERVICE : ApiService by lazy { retrofit.create(ApiService::class.java) }
}