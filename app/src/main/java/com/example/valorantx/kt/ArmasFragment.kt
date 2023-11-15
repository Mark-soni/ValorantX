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
import com.example.valorantx.controllers.ArmasAdapter
import com.example.valorantx.controllers.OnClickListener
import com.example.valorantx.databinding.FragmentArmasBinding
import com.example.valorantx.models.Armas

class ArmasFragment : Fragment(), OnClickListener {

    private lateinit var binding: FragmentArmasBinding
    private var mContext = this.context
    private lateinit var armasAdapter: ArmasAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager


    override fun onClick(armas: Armas, position: Int) {
        Toast.makeText(mContext, "${armas.nombre}: ${armas.id}", Toast.LENGTH_LONG).show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {

        binding = FragmentArmasBinding.inflate(inflater, container, false)


        armasAdapter = ArmasAdapter(emptyList(),this)
        linearLayoutManager = LinearLayoutManager(mContext)


        binding.rvArmas.apply{
            layoutManager = linearLayoutManager
            adapter = armasAdapter
        }

        var lista:MutableList<Armas> = mutableListOf<Armas>()

        var phanton = Armas("1","Phanton","https://www.zleague.gg/theportal/wp-content/uploads/2023/05/Phantom-Valorant-weapon-guide-title-card-aspect-ratio-2-1.png","Metralleta","30","Armas de larga distancia con silenciados")
        var vandal = Armas("2","Vandal","https://www.zleague.gg/theportal/wp-content/uploads/2023/05/Vandal-Valorant-weapon-guide-title-card-aspect-ratio-2-1.png","Metralleta","25","Armas de larga distancia sin silenciador")

        lista.add(phanton)
        lista.add(vandal)
        lista.add(phanton)
        lista.add(vandal)
        lista.add(phanton)
        lista.add(vandal)
        lista.add(phanton)
        lista.add(vandal)

        armasAdapter.updateData(lista)

        return binding.root
    }



}