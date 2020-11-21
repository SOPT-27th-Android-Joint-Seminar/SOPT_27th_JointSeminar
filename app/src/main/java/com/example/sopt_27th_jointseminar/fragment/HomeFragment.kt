package com.example.sopt_27th_jointseminar.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sopt_27th_jointseminar.MainAdapter
import com.example.sopt_27th_jointseminar.R
import com.example.sopt_27th_jointseminar.item
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

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
        home_rcv.layoutManager= GridLayoutManager(view.context,2)
        mainAdapter.itemList=mutableListOf(
            item(R.drawable.rectangle_12,"유아 장갑","신촌동 /","10초 전","10,000원",45,21),
            item(R.drawable.rectangle_13,"상품명","신촌동 /","10초 전","10,000원",0,0),
            item(R.drawable.rectangle_14,"상품명","신촌동 /","10초 전","10,000원",990,999),
            item(R.drawable.rectangle_15,"상품명이길어지면어디까지가능할까","신촌동 /","10초 전","10,000원",990,999),
            item(R.drawable.rectangle_16,"상품명이길어지면어디까지가능할까","신촌동 /","10초 전","10,000원",90,999),
            item(R.drawable.rectangle_17,"상품명","신촌동 /","10초 전","10,000원",90,999)
        )
        mainAdapter.notifyDataSetChanged()
    }
}