package com.example.tugasclient.custom

import com.example.tugasclient.model.MyModel
import retrofit2.Call
import retrofit2.http.GET

interface MyServices{
    @GET("posts")
    fun getPosts(): Call<List<MyModel>>
}