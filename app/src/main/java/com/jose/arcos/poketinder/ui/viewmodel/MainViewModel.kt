package com.jose.arcos.poketinder.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jose.arcos.poketinder.data.model.PokemonListResponse
import com.jose.arcos.poketinder.data.model.PokemonResponse
import com.jose.arcos.poketinder.data.network.PokemonApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel(){

    val pokemonList = MutableLiveData<List<PokemonResponse>>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        getAllPokemons()
    }

    private fun getAllPokemons(){
        isLoading.postValue(true)
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(PokemonApi::class.java).getPokemons()
            isLoading.postValue(false)
            if (call.isSuccessful) {
                call.body()?.let{
                    pokemonList.postValue(it.results)
                }
            }
        }
    }

    private fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/pokemon/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}