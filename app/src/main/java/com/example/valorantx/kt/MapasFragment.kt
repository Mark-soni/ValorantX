package com.example.valorantx.kt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.valorantx.R
import com.example.valorantx.controllers.MapasAdapter
import com.example.valorantx.controllers.OnClickListener
import com.example.valorantx.databinding.FragmentMapasBinding
import com.example.valorantx.models.Mapas

class MapasFragment : Fragment(), OnClickListener {

    private lateinit var binding: FragmentMapasBinding
    private var mContext = this.context
    private lateinit var mapasAdapter: MapasAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    override fun onClick(mapas: Mapas, position: Int) {
        Toast.makeText(mContext, "${mapas.nombre}: ${mapas.id}", Toast.LENGTH_LONG).show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {

        binding = FragmentMapasBinding.inflate(inflater, container, false)


        mapasAdapter = MapasAdapter(emptyList(),this)
        linearLayoutManager = LinearLayoutManager(mContext)


        binding.rvMapas.apply{
            layoutManager = linearLayoutManager
            adapter = mapasAdapter
        }

        var lista:MutableList<Mapas> = mutableListOf<Mapas>()

        var split = Mapas("1","Split","https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltee14888179d221f8/5ee7d51725b4740c330ba55d/Loading_Screen_Split_v2.jpg","Mapa en una parte de asia","","Defensa")
        var bind = Mapas("2","Bind","https://static.wikia.nocookie.net/valorant/images/2/23/Loading_Screen_Bind.png/revision/latest?cb=20200620202316","","Mapa en arabias","Ataque")

        lista.add(split)
        lista.add(bind)
        lista.add(split)
        lista.add(bind)
        lista.add(split)
        lista.add(bind)
        lista.add(split)
        lista.add(bind)

        mapasAdapter.updateData(lista)

        return binding.root
    }
}