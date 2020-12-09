package com.example.sopt_27th_jointseminar.server

data class DetailResponseBody(val status:Int,val success:Boolean,val message:String,val data:List<Data2>)
{
    data class Data2(val idx:Int,val price:Int,val category:String,val detail:String,val likeNum:Int,val commentNum:Int,val viewCnt:Int,val upAgain:String,val isNegoAble:Int,val user_idx:Int,val createdAt:String,
    val productName:String,val manner:Int,val local:String,val nickName:String,val user_img:String)
}
