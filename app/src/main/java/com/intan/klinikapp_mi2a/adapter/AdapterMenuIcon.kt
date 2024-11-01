package com.intan.klinikapp_mi2a.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.intan.klinikapp_mi2a.R
import com.intan.klinikapp_mi2a.model.ModelMenuIcon

class AdapterMenuIcon(
    val itemMenuList: List<ModelMenuIcon>
): RecyclerView.Adapter<AdapterMenuIcon.MyviewHolder>(){
    class MyviewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var imgMenuIcon : ImageView = itemView.findViewById(R.id.imgIcon)
        var txtNamaMenu : TextView = itemView.findViewById(R.id.txtNamaIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menuicon,parent,false)
        return MyviewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemMenuList.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        val currentItem = itemMenuList[position]
        holder.imgMenuIcon.setImageResource(currentItem.imgMenu)
        holder.txtNamaMenu.setText(currentItem.namaMenu)
    }

}