package com.yerayyas.daggerhiltcompose.domain.repository

import com.yerayyas.daggerhiltcompose.data.remote.PokeApi
import com.yerayyas.daggerhiltcompose.presentation.util.Resource
import com.yerayyas.daggerhiltcompose.data.remote.responses.Pokemon
import com.yerayyas.daggerhiltcompose.data.remote.responses.PokemonList
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName:String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured")
        }
        return Resource.Success(response)
    }
}