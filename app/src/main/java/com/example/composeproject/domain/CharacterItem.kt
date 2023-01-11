package com.example.composeproject.domain

import com.example.composeproject.data.remote.model.CharacterModel

data class CharacterItem (
    val id: Int,
    val title: String,
    val description: String,
    val image: String
)

fun CharacterModel.toCharacterItem() = CharacterItem(id, title, description, image)
