package com.example.hermioneapi.ui

import com.example.hermioneapi.data.Character

data class HomeState(
    val isLoading: Boolean = false,
    val characters: List<Character> = emptyList(),
    val message: String = ""
)
