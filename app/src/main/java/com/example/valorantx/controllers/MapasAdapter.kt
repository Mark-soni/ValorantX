package com.example.valorantx.controllers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.valorantx.R
import com.example.valorantx.databinding.ItemMapasBinding
import com.example.valorantx.models.Mapas

class MapasAdapter(private var mapas:List<Mapas>, private var listener: OnClickListener) : RecyclerView.Adapter<MapasAdapter.ViewHolder>() {
    private lateinit var context : Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapasAdapter.ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_mapas, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mapas = mapas.get(position)

        with(holder) {
            setListener(mapas, position)
            binding.nombreMapas.text = mapas.nombre.toString()
            binding.tipoMapas.text = mapas.tipo.toString()

            Glide.with(context)
                .load(mapas.foto)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerInside()
                .into(binding.imgMapas)
        }
    }



    override fun getItemCount(): Int = mapas.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val binding = ItemMapasBinding.bind(view)

        fun setListener(mapas: Mapas, position: Int) {
            binding.root.setOnClickListener{ listener.onClick(mapas, position) }
        }
    }

    fun updateData(newData: List<Mapas>) {
        mapas = newData
        notifyDataSetChanged()
    }

}