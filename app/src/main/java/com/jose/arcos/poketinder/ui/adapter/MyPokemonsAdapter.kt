package com.jose.arcos.poketinder.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jose.arcos.poketinder.R
import com.jose.arcos.poketinder.data.database.entities.MyPokemonEntity
import com.jose.arcos.poketinder.databinding.ItemPokemonSavedBinding
import com.jose.arcos.poketinder.ui.holder.MyPokemonHolder

class MyPokemonsAdapter(val list: List<MyPokemonEntity>): RecyclerView.Adapter<MyPokemonHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPokemonHolder {
        val view = ItemPokemonSavedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyPokemonHolder(view.root)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MyPokemonHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }
}