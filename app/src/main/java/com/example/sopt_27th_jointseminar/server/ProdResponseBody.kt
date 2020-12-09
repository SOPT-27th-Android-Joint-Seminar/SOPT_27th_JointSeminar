package com.example.sopt_27th_jointseminar.server

data class ProdResponseBody(val status:Int,val success:Boolean,val message:String,val data:List<Data>)
{
    data class Data(val idx:Int,val productName:String,val price:Int,val likeNum:Int,val commentNum:Int,val createdAt:String,val local:String,val imgLink:String)
}
