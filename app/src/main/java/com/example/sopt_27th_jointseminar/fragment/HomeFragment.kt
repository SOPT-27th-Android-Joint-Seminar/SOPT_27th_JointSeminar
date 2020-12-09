package com.example.sopt_27th_jointseminar.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sopt_27th_jointseminar.MainAdapter
import com.example.sopt_27th_jointseminar.R
import com.example.sopt_27th_jointseminar.item
import com.example.sopt_27th_jointseminar.server.ProdResponseBody
import com.example.sopt_27th_jointseminar.server.RetrofitGenerator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class HomeFragment : Fragment() {
    private lateinit var mainAdapter: MainAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imagebutton_close.setOnClickListener {
            constraint_close.visibility = View.GONE
            view_close.visibility = View.GONE
        }
        //recyclerview 붙이기

        mainAdapter=MainAdapter(view.context)
        home_rcv.adapter=mainAdapter
        PostGetServer()
        val r= Runnable {
            try{
                //goalList=goalDatabase?.goalDao?.getGoal()!!
                mainAdapter=MainAdapter(view.context)
                mainAdapter.notifyDataSetChanged()

                home_rcv.adapter=mainAdapter
                home_rcv.layoutManager=
                    GridLayoutManager(view.context, 2)
                home_rcv.setHasFixedSize(true)


            }catch (e:Exception){
                Log.d("tag", "Error - $e")
            }
        }
        val thread=Thread(r)
        thread.start()

        /*home_rcv.layoutManager= GridLayoutManager(view.context,2)
        mainAdapter.itemList=mutableListOf(
            item(R.drawable.rectangle_12,"유아 장갑","신촌동 /","10초 전","10,000원",45,21),
            item(R.drawable.rectangle_13,"상품명","신촌동 /","10초 전","10,000원",0,0),
            item(R.drawable.rectangle_14,"상품명","신촌동 /","10초 전","10,000원",990,999),
            item(R.drawable.rectangle_15,"상품명이길어지면어디까지가능할까","신촌동 /","10초 전","10,000원",990,999),
            item(R.drawable.rectangle_16,"상품명이길어지면어디까지가능할까","신촌동 /","10초 전","10,000원",90,999),
            item(R.drawable.rectangle_17,"상품명","신촌동 /","10초 전","10,000원",90,999)
        )*/
        mainAdapter.notifyDataSetChanged()
    }

    private fun PostGetServer(){
        //Retrofit 서버 연결
        val call= RetrofitGenerator.create().getProdList()
        //val call=RetrofitGenerator.create().registerPost(postRequest,"Token "+TokenTon.Token)
        call.enqueue(object : Callback<ProdResponseBody> {
            override fun onResponse(call: Call<ProdResponseBody>?, response: Response<ProdResponseBody>) {
                //토큰 값 받아오기
                //Toast.makeText(this@AddGoalActivity,response.body()?.title.toString(),Toast.LENGTH_LONG).show()
                //TokenTon.set(response.body()?.token.toString())
                // )
                if(response?.isSuccessful==false){

                    Toast.makeText(activity!!.applicationContext,"${response?.code()}", Toast.LENGTH_LONG).show()
                }else {
                    Toast.makeText(activity!!.applicationContext,"${response?.body()?.data?.get(0)!!.idx}",
                        Toast.LENGTH_LONG).show()
                    try {
                        mainAdapter.setListItems(response?.body()?.data!!)
                    } catch (e: Exception) {
                        //    Toast.makeText(this@MainActivity,"$e",Toast.LENGTH_LONG).show()
                    }
                    if (response?.body() != null) {
                        //  Toast.makeText(this@MainActivity,response.body()!![0].title,Toast.LENGTH_LONG).show()
                        mainAdapter.setListItems(response?.body()?.data!!)
                    }
                    //목표 갯수



                }
            }
            override fun onFailure(call: Call<ProdResponseBody>, t: Throwable) {

            }
        })
    }
}