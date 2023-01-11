package com.example.composeproject.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeproject.data.remote.model.CharacterModel
import com.example.composeproject.domain.CharacterItem
import com.example.composeproject.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val _character = MutableStateFlow(emptyList<CharacterItem>())
    val characters: StateFlow<List<CharacterItem>> get() = _character

    init {
        getCharacter()
    }

    private fun getCharacter() {
        viewModelScope.launch {
            try {
                val characters = repository.getCharacter()
                _character.value = characters
            } catch (ex : Exception) {
            }
        }
    }
}