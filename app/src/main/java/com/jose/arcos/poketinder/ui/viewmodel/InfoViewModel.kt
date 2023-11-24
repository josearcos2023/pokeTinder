package com.jose.arcos.poketinder.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jose.arcos.poketinder.data.network.FirebaseRemoteConfigRepository

class InfoViewModel: ViewModel() {

    private var firebaseRemoteConfigRepository = FirebaseRemoteConfigRepository()

    init {
        firebaseRemoteConfigRepository.init()
    }

    fun getUrlPokemon(): MutableLiveData<String> {
        return firebaseRemoteConfigRepository.getUrlPokemonLiveData
    }

}