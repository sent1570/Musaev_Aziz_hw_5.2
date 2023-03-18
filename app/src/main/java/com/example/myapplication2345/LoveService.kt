package com.example.myapplication2345

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class LoveService {
   private val retrofit = Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/").addConverterFactory(GsonConverterFactory.create()).build()
var api = retrofit.create(LoveApi::class.java)
}