package com.jose.arcos.poketinder.ui.view

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.fragment.app.viewModels
import com.jose.arcos.poketinder.databinding.FragmentHomeBinding
import com.jose.arcos.poketinder.databinding.FragmentInfoBinding
import com.jose.arcos.poketinder.ui.viewmodel.InfoViewModel

class InfoFragment : BaseFragment<FragmentInfoBinding>(FragmentInfoBinding::inflate) {

    private val viewModel: InfoViewModel by viewModels()

    private lateinit var webView: WebView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val url = "https://pokemongolive.com/es/"

        webView = binding.wvInfoFragment

        webView.settings.javaScriptEnabled = true

        viewModel.getUrlPokemon().observe(viewLifecycleOwner){
            webView.loadUrl(it)
        }

        //webView.loadUrl(url)

    }

}