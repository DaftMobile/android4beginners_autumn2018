package com.daftmobile.android4beginners6pokedex

import android.support.annotation.ColorInt
import com.daftmobile.android4beginners6pokedex.api.Pokemon
import com.daftmobile.android4beginners6pokedex.api.PokemonFetcher
import java.io.Serializable

data class PokemonItem(val index: Int, val numberLabel: String, val name: String, @ColorInt val color: Int): Serializable {
    constructor(pokemon: Pokemon): this(
        pokemon.number,
        String.format("#%03d", pokemon.number),
        pokemon.name,
        pokemon.color or 0xff000000.toInt()
    )

    val thumbnailUrl = "${PokemonFetcher.API_BASE_URL}api/pokemon/$index/thumbnail"
    val imageUrl = "${PokemonFetcher.API_BASE_URL}api/pokemon/$index/image"
}
