package com.example.mini_astro.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mini_astro.R
import com.example.mini_astro.modals.MyModel
import com.example.mini_astro.ui.home.HomeFragment

class MyAdapter(var context: HomeFragment, var listArray: ArrayList<MyModel>):
    RecyclerView.Adapter<MyAdapter.ItemHolder>(){

        class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            var icons = itemView.findViewById<ImageView>(R.id.icon_image)
            var txt = itemView.findViewById<TextView>(R.id.txtTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        var itemholder = LayoutInflater.from(parent.context)
            .inflate(R.layout.grid_item
                ,parent, false)
        return ItemHolder(itemholder)
    }

    override fun onBindViewHolder(holder: MyAdapter.ItemHolder, position: Int) {
        var myCard: MyModel = listArray.get(position)

        holder.icons.setImageResource(myCard.iconsCard!!)
        holder.txt.text = myCard.textCard

        holder.txt.setOnClickListener{
          //  Toast.makeText(context,myCard.textCard, Toast.LENGTH_LONG)
        }
    }

    override fun getItemCount(): Int {
        return listArray.size
    }
}