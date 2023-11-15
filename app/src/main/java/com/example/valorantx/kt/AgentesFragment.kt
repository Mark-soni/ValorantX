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
import com.example.valorantx.controllers.AgenteAdapter
import com.example.valorantx.controllers.OnClickListener
import com.example.valorantx.databinding.FragmentAgentesBinding
import com.example.valorantx.models.Agente

class AgentesFragment : Fragment(), OnClickListener {

    private lateinit var binding: FragmentAgentesBinding
    private var mContext = this.context
    private lateinit var agenteAdapter: AgenteAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    //funcion que reacciona al click a una carta
    override fun onClick(agente: Agente, position: Int) {
        Toast.makeText(mContext, "${agente.nombre}: ${agente.id}", Toast.LENGTH_LONG).show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        //declaracion del binding en un fragment
        binding = FragmentAgentesBinding.inflate(inflater, container, false)

        // INICIALIZACIÓN
        agenteAdapter = AgenteAdapter(emptyList(),this)
        linearLayoutManager = LinearLayoutManager(mContext)

        // RECYCLEVIEW
        binding.rvAgentes.apply{
            layoutManager = linearLayoutManager
            adapter = agenteAdapter
        }

        var lista:MutableList<Agente> = mutableListOf<Agente>()

        var breach = Agente("1","Breach","https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt100d13bfa8286a3d/5eb7cdc11ea0c32e33b95fa2/V_AGENTS_587x900_Breach.png", "Iniciador","q","e","c","x","es breach")
        var fade = Agente("2","Fade","https://static.wikia.nocookie.net/valorant-lore/images/2/2e/Fade_-_Full_Body.png/revision/latest?cb=20220511172812", "Iniciador","q","e","c","x","es fade")

        lista.add(fade)
        lista.add(breach)
        lista.add(fade)
        lista.add(breach)
        lista.add(fade)
        lista.add(breach)
        lista.add(fade)
        lista.add(breach)

        agenteAdapter.updateData(lista)

        return binding.root
    }



}