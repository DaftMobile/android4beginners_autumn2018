package com.daftmobile.android4beginners6pokedex.recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.daftmobile.android4beginners6pokedex.PokemonItem
import com.daftmobile.android4beginners6pokedex.R

/**
 * Created by Konrad Kowalewski.
 */
class PokemonAdapter(
    var items: List<PokemonItem>,
    private val onItemClicked: (PokemonItem) -> Unit
): RecyclerView.Adapter<PokemonViewHolder>() {
    // TODO implement adapter
}
