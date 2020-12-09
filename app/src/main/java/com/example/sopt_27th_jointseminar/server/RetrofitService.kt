package com.example.sopt_27th_jointseminar.server

import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {
    //@Headers("Content-Type: application/json")
    @GET("/productList")
    fun getProdList() : Call<ProdResponseBody>

    /*@GET("/product?productIdx={productidx}")
    fun getDetail(@Path("productidx") idx:Int?):Call<DetailResponseBody>*/
    //Path가 안먹힐때 Query 뭐시기 에러가 나오면 이렇게
    @GET("/product")
    fun getDetail(@Query("productIdx") idx:Int?):Call<DetailResponseBody>

    @GET("/product/image")
    fun getImage(@Query("productIdx") idx:Int?):Call<ImageResponseBody>
}