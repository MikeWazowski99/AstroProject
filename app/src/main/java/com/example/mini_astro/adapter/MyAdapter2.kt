package com.example.mini_astro.adapter

import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mini_astro.R
import com.example.mini_astro.modals.MyModel
import com.example.mini_astro.modals.myModel2
import com.example.mini_astro.ui.notifications.NotificationsFragment

class MyAdapter2(var context: NotificationsFragment, var listArray2: ArrayList<myModel2>):
    RecyclerView.Adapter<MyAdapter2.ItemHolder>(){

        class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            var icons = itemView.findViewById<ImageView>(R.id.icon_image)
            var txt = itemView.findViewById<TextView>(R.id.txtTitle)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
            var itemholder = LayoutInflater.from(parent.context)
                .inflate(R.layout.grid_item2
                    ,parent, false)
            return ItemHolder(itemholder)
        }

        override fun onBindViewHolder(holder: MyAdapter2.ItemHolder, position: Int) {
            var myCard: myModel2 = listArray2.get(position)

            holder.icons.setImageResource(myCard.iconsCard2!!)
            holder.txt.text = myCard.textCard2

            holder.txt.setOnClickListener{
                //  Toast.makeText(context,myCard.textCard, Toast.LENGTH_LONG)
            }
        }

        override fun getItemCount(): Int {
            return listArray2.size
        }
    }