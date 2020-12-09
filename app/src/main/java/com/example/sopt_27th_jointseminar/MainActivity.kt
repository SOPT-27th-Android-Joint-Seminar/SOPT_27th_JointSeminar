package com.example.sopt_27th_jointseminar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.sopt_27th_jointseminar.fragment.*
import com.example.sopt_27th_jointseminar.server.ProdResponseBody
import com.example.sopt_27th_jointseminar.server.RetrofitGenerator
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    private lateinit var viewpagerAdapter : ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Theme에 의해 구조적으로 포함되어 있는 Tint 초기화
        main_bottom_navi.itemIconTintList = null

        //viewpager 세팅
        viewpagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewpagerAdapter.fragments = listOf(
            HomeFragment(),
            RoomFragment(),
            MapFragment(),
            QuestionFragment(),
            PersonFragment()
        )

        main_viewpager.adapter = viewpagerAdapter

        //bottom navigation 세팅
        main_bottom_navi.setOnNavigationItemSelectedListener {
            var index by Delegates.notNull<Int>()
            when(it.itemId) {
                R.id.menu_home -> index = 0
                R.id.menu_room -> index = 1
                R.id.menu_map -> index = 2
                R.id.menu_question -> index = 3
                R.id.menu_person -> index = 4
            }
            main_viewpager.currentItem = index
            true
        }

        //viewpager slide 시 bottom navi 변경
        main_viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            //viewpager의 페이지 중 하나가 선택된 경우
            override fun onPageSelected(position: Int) {
                main_bottom_navi.menu.getItem(position).isChecked = true
            }

        })




    }


}