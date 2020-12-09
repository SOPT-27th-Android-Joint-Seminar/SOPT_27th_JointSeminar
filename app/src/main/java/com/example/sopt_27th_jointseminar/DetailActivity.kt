package com.example.sopt_27th_jointseminar

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.sopt_27th_jointseminar.server.DetailResponseBody
import com.example.sopt_27th_jointseminar.server.ImageResponseBody
import com.example.sopt_27th_jointseminar.server.ProdResponseBody
import com.example.sopt_27th_jointseminar.server.RetrofitGenerator
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val idx=getIntent().getIntExtra("idx",0)
        GetImgServer(idx)
        GetServer(idx)

    }

    private fun GetServer(idx:Int){
        //Retrofit 서버 연결
        val call= RetrofitGenerator.create().getDetail(idx)
        //val call=RetrofitGenerator.create().registerPost(postRequest,"Token "+TokenTon.Token)
        call.enqueue(object : Callback<DetailResponseBody> {
            override fun onResponse(call: Call<DetailResponseBody>?, response: Response<DetailResponseBody>) {

                if(response?.isSuccessful==false){

                    Toast.makeText(applicationContext,"${response?.code()}", Toast.LENGTH_LONG).show()
                }else {


                    if (response?.body() != null) {
                        price.text="${response!!.body()!!.data.get(0).price}"
                        detail.text=response!!.body()!!.data.get(0).detail
                        likeNum.text="관심 ${response!!.body()!!.data.get(0).likeNum}"
                        commentNum.text="채팅 ${response!!.body()!!.data.get(0).commentNum}개"
                        viewCnt.text="조회 ${response!!.body()!!.data.get(0).viewCnt}"
                        upAgain.text=response!!.body()!!.data.get(0).category+" ' "+response!!.body()!!.data.get(0).upAgain
                        productName.text=response!!.body()!!.data.get(0).productName
                        manner.text="${response!!.body()!!.data.get(0).manner}℃ "
                        local.text=response!!.body()!!.data.get(0).local
                        nickName.text=response!!.body()!!.data.get(0).nickName


                    }




                }
            }
            override fun onFailure(call: Call<DetailResponseBody>, t: Throwable) {

            }
        })
    }

    private fun GetImgServer(idx:Int){
        //Retrofit 서버 연결
        val call= RetrofitGenerator.create().getImage(idx)
        //val call=RetrofitGenerator.create().registerPost(postRequest,"Token "+TokenTon.Token)
        call.enqueue(object : Callback<ImageResponseBody> {
            override fun onResponse(call: Call<ImageResponseBody>?, response: Response<ImageResponseBody>) {

                if(response?.isSuccessful==false){

                    Toast.makeText(applicationContext,"${response?.code()}", Toast.LENGTH_LONG).show()
                }else {


                    if (response?.body() != null) {

                        Glide.with(applicationContext)
                            .load(response?.body()!!.data.get(0).imgLink)
                            .into(imageView)

                    }




                }
            }
            override fun onFailure(call: Call<ImageResponseBody>, t: Throwable) {

            }
        })
    }
}