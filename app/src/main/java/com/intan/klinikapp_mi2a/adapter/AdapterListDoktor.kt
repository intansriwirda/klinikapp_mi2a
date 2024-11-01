package com.intan.klinikapp_mi2a.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.intan.klinikapp_mi2a.PageDokterActivity
import com.intan.klinikapp_mi2a.R
import com.intan.klinikapp_mi2a.model.ModelListDoctor

class AdapterListDoktor(
    private val itemMenuDoktor: List<ModelListDoctor>
) : RecyclerView.Adapter<AdapterListDoktor.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgdoktor: ImageView = itemView.findViewById(R.id.imgdoktor)
        var namadoktor: TextView = itemView.findViewById(R.id.namadoktor)
        var spesialis: TextView = itemView.findViewById(R.id.txtspesialis)
        var txtJumlahRating: TextView = itemView.findViewById(R.id.txtJumlahRating)
        var txtrating: TextView = itemView.findViewById(R.id.txtrating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_listdoktor, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemMenuDoktor.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemMenuDoktor[position]
        holder.imgdoktor.setImageResource(currentItem.imgDoctor)
        holder.namadoktor.text = currentItem.namaDoctor
        holder.spesialis.text = currentItem.spesiesDoctor
        holder.txtJumlahRating.text = currentItem.jumlahReting
        holder.txtrating.text = currentItem.angkarating

        // Set click listener untuk item
        holder.itemView.setOnClickListener {
            // Buat Intent untuk menuju PageDokterActivity
            val intent = Intent(holder.itemView.context, PageDokterActivity::class.java)
            // Kirim data yang diperlukan ke Activity berikutnya
            intent.putExtra("imageResId", currentItem.imgDoctor)
            intent.putExtra("namaDokter", currentItem.namaDoctor)
            intent.putExtra("spesialis", currentItem.spesiesDoctor)
            intent.putExtra("jumlahRating", currentItem.jumlahReting)
            intent.putExtra("rating", currentItem.angkarating)
            // Mulai activity
            holder.itemView.context.startActivity(intent)
        }
    }
}