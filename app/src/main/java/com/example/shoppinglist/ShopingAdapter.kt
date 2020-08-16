package com.example.shoppinglist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class ShopingAdapter(
    var itemList:List<Shopping_item>,
val viewModel: ShopingViewModel
) :RecyclerView.Adapter<ShopingAdapter.ShopingItemHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopingItemHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ShopingItemHolder(view)
    }

    override fun getItemCount(): Int {
       return itemList.size
    }

    override fun onBindViewHolder(holder: ShopingItemHolder, position: Int) {
        var current=itemList[position]
        holder.itemView.tvItemName.text=current.itemname
        holder.itemView.tvItemAmount.text="(${current.quantity})"
        holder.itemView.ivItemDelete.setOnClickListener{
            viewModel.delete(current)
        }
        holder.itemView.ivItemMinus.setOnClickListener {
            if(current.quantity>0){
                current.quantity--
                viewModel.upsert(current)
            }
        }
        holder.itemView.ivItemAdd.setOnClickListener {
                current.quantity++
                viewModel.upsert(current)

        }
    }

    inner class ShopingItemHolder(itemview:View):RecyclerView.ViewHolder(itemview)
}