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
import com.bumptech.glide.Glide
import com.example.sopt_27th_jointseminar.server.ProdResponseBody
import kotlinx.android.synthetic.main.main_item.view.*

class MainAdapter(context : Context) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    var itemList:List<ProdResponseBody.Data> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        itemList[position].let{ item ->
            with(holder) {
                nameText.text=item.productName
                placeText.text=item.local
                timeText.text=item.createdAt
                priceText.text="${item.price}원"
                likeText.text="${item.likeNum}"
                chatText.text="${item.commentNum}"
                if(item.imgLink!=null) {
                    Glide.with(holder.itemView.context)
                        .load(item.imgLink)
                        .into(imageView)
                }
            }
        }
        holder.itemView.setOnClickListener { view->   //수정에 정보날림
            val intent = Intent(view.context, DetailActivity::class.java)
            intent.putExtra("idx",itemList[position].idx)
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
    fun setListItems(itemList: List<ProdResponseBody.Data>){
        this.itemList = itemList;
        notifyDataSetChanged()
    }

}