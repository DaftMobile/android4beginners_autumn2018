package com.daftmobile.android4beginners6pokedex

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pokemon.*

class PokemonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon)

        val pokemonItem = intent.getSerializableExtra(EXTRA_KEY) as? PokemonItem ?: throw IllegalStateException("No pokemon item")

        val viewModel = ViewModelProviders.of(this).get(PokemonViewModel::class.java)
        viewModel.pokemonInfo().observe(this, Observer(this::updatePokemonInfo))
        viewModel.error().observe(this, Observer(this::showError))
        viewModel.isCatchButtonEnabled().observe(this, Observer {
            catchButton.isEnabled = it == true
        })

        viewModel.setPokemonItem(pokemonItem)

        catchButton.setOnClickListener {
            viewModel.catchPokemon()
        }
    }

    private fun showError(message: String?) {
        if (message == null) return
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun updatePokemonInfo(pokemonItem: PokemonItem?) {
        if (pokemonItem == null) return
        title = pokemonItem.numberLabel
        nameView.text = pokemonItem.name
        Picasso.get().load(pokemonItem.imageUrl).fit().centerInside().into(imageView)
        imageView.setBackgroundColor(pokemonItem.color or 0xff000000.toInt())
    }

    companion object {
        const val EXTRA_KEY = "pokemon_extra"
    }
}
