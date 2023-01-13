package com.example.composeproject.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeproject.domain.ProductItem
import com.example.composeproject.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by OMK on 11/01/23.
 */

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val _character = MutableStateFlow(emptyList<ProductItem>())
    val characters: StateFlow<List<ProductItem>> get() = _character

    init {
        getCharacter()
    }

    private fun getCharacter() {
        viewModelScope.launch {
            try {
                val characters = repository.getProduct()
                _character.value = characters
            } catch (ex : Exception) {
            }
        }
    }
}