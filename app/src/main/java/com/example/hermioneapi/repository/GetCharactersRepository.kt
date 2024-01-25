package com.example.hermioneapi.repository

import com.example.hermioneapi.data.Character
import com.example.hermioneapi.util.Resource
import kotlinx.coroutines.flow.Flow

interface GetCharactersRepository {

    fun getCharacters() : Flow<Resource<List<Character>>>

}