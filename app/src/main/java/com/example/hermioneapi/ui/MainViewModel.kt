package com.example.hermioneapi.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hermioneapi.repository.GetCharactersRepository
import com.example.hermioneapi.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val charactersRepository: GetCharactersRepository
): ViewModel(){

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            charactersRepository.getCharacters().collect{ result ->

                when(result){
                    is Resource.Loading -> {
                        _state.value = HomeState(
                            isLoading = true
                        )
                    }

                    is Resource.Success -> {
                        _state.value = HomeState(
                            characters = result.data ?: emptyList()
                        )
                    }

                    is Resource.Error -> {
                        _state.value = HomeState(
                            message = result.message ?: "Something went wrong"
                        )
                    }
                }
            }
        }
    }
}