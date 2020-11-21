package com.example.sopt_27th_jointseminar

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main_item.view.*

class MainAdapter(context : Context) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    var itemList=mutableListOf<item>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        itemList[position].let{ item ->
            with(holder) {
                nameText.text=item.name
                placeText.text=item.place
                timeText.text=item.time
                priceText.text=item.price
                likeText.text="${item.like}"
                chatText.text="${item.chat}"
                if(item.image!=null) {

                    imageView.setImageResource(item.image)
                }
            }
        }
        holder.itemView.setOnClickListener { view->   //수정에 정보날림
            val intent = Intent(view.context, DetailActivity::class.java)

            view.context.startActivity(intent)
        }



    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView =view.item_Image
        val nameText:TextView=view.item_name
        val placeText:TextView=view.item_place
        val timeText:TextView=view.item_time
        val priceText:TextView=view.item_price
        val likeText:TextView=view.item_heart
        val chatText:TextView=view.item_chat



    }

}