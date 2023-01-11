package com.example.composeproject.repo

import com.example.composeproject.domain.CharacterItem

interface UserRepository {
    suspend fun  getCharacter(): List<CharacterItem>
}