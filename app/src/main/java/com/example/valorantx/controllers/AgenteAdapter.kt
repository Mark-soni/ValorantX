package com.example.valorantx.controllers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.valorantx.R
import com.example.valorantx.databinding.ItemAgenteBinding
import com.example.valorantx.models.Agente

class AgenteAdapter(private var agentes:List<Agente>, private var listener: OnClickListener) : RecyclerView.Adapter<AgenteAdapter.ViewHolder>() {
    private lateinit var context : Context

    //sirve para inflar la vista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgenteAdapter.ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_agente, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val agente = agentes.get(position) //obtiene el agente a manera de foreach

        with(holder) {
            setListener(agente, position)
            binding.nombreAgente.text = agente.nombre.toString()
            binding.rolAgente.text = agente.rol.toString()
            //seccion de la foto
            Glide.with(context)
                .load(agente.foto)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerInside()
                .into(binding.imgAgente)
        }
    }



    override fun getItemCount(): Int = agentes.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        //conectar el binding con el binding deseado
        val binding = ItemAgenteBinding.bind(view)

        fun setListener(agente: Agente, position: Int) {
            binding.root.setOnClickListener{ listener.onClick(agente, position) }
        }
    }

    fun updateData(newData: List<Agente>) {
        agentes = newData
        notifyDataSetChanged()
    }

}