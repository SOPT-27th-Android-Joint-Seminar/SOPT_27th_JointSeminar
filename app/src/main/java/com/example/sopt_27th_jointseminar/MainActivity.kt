package com.example.sopt_27th_jointseminar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Theme에 의해 구조적으로 포함되어 있는 Tint 초기화
        main_bottom_navi.itemIconTintList = null
    }
}