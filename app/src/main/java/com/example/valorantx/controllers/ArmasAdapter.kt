package com.example.valorantx.controllers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.valorantx.R
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.valorantx.databinding.ItemArmasBinding
import com.example.valorantx.models.Armas

class ArmasAdapter(private var armas: List<Armas>, private var listener: OnClickListener) : RecyclerView.Adapter<ArmasAdapter.ViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArmasAdapter.ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_armas, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val armas = armas[position]

        with(holder) {
            setListener(armas, position)
            binding.nombreArmas.text = armas.nombre
            binding.municionArmas.text = armas.municion.toString()

            Glide.with(context)
                .load(armas.foto)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerInside()
                .into(binding.imgArmas)
        }
    }

    override fun getItemCount(): Int = armas.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemArmasBinding.bind(view)

        fun setListener(armas: Armas, position: Int) {
            binding.root.setOnClickListener { listener.onClick(armas, position) }
        }
    }

    fun updateData(newData: List<Armas>) {
        armas = newData
        notifyDataSetChanged()
    }
}
