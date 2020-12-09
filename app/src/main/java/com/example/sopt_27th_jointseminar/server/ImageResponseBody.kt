package com.example.sopt_27th_jointseminar.server

data class ImageResponseBody(val status:Int,val success:Boolean,val message:String,val data:List<Data3>)
{
    data class Data3(val idx:Int,val imgLink:String,val product_idx:Int)
}