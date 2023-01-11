package com.example.composeproject.repo


import com.example.composeproject.data.api.CharacterApi
import com.example.composeproject.domain.toCharacterItem
import javax.inject.Inject

class Repository @Inject constructor(
    private val characterApi:CharacterApi,
): UserRepository {
    override suspend fun getCharacter()= characterApi.getCharacter().map { it.toCharacterItem() }
}