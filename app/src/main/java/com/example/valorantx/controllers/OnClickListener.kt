package com.example.valorantx.controllers

import com.example.valorantx.models.Agente
import com.example.valorantx.models.Armas
import com.example.valorantx.models.Mapas

interface OnClickListener {
    fun onClick(agente: Agente, position: Int) {

    }
    fun onClick(armas: Armas, position: Int) {
    }
    fun onClick(mapas: Mapas, position: Int) {
    }
}

