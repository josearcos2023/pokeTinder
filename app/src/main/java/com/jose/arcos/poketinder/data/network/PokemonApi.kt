package com.jose.arcos.poketinder.data.network

import com.jose.arcos.poketinder.data.model.PokemonListResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApi {
    @GET("?limit=40")
    suspend fun getPokemons(): Response<PokemonListResponse>
}