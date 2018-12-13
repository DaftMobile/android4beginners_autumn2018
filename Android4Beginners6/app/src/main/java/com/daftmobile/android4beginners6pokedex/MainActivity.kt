package com.daftmobile.android4beginners6pokedex

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import com.daftmobile.android4beginners6pokedex.api.PokemonFetcher
import com.daftmobile.android4beginners6pokedex.recycler.PokemonAdapter
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: PokedexViewModel by lazy { ViewModelProviders.of(this).get(PokedexViewModel::class.java) }
    // TODO create Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupPicasso()
        // TODO hook adapter
        viewModel.pokemonList().observe(this, Observer(this::updatePokemonList))
        viewModel.error().observe(this, Observer(this::showError))
        viewModel.refresh()
    }

    override fun onRestart() {
        super.onRestart()
        viewModel.refresh()
    }

    private fun updatePokemonList(pokemonList: List<PokemonItem>?) {
        if (pokemonList == null) return
        // TODO update adapter
    }

    private fun showPokemonActivity(pokemon: PokemonItem) {
        val intent = Intent(this, PokemonActivity::class.java)
                .putExtra(PokemonActivity.EXTRA_KEY, pokemon)
        startActivity(intent)
    }

    private fun showError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun setupPicasso() {
        val picasso = Picasso.Builder(this)
                .downloader(OkHttp3Downloader(PokemonFetcher.HTTP_CLIENT))
                .build()
        Picasso.setSingletonInstance(picasso)
    }
}
