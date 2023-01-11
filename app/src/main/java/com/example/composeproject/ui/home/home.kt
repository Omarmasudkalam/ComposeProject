package com.example.composeproject.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.composeproject.data.remote.model.CharacterModel
import com.example.composeproject.domain.CharacterItem

@Composable
fun HomeScreen() {
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val characters by homeViewModel.characters.collectAsState()

    LazyColumn {

        items(characters) { character: CharacterItem ->
            CharacterCard(character = character)
        }
    }
}

@Composable
fun CharacterCard(character: CharacterItem) {

    val image = rememberImagePainter(data = character.image)
    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp, start = 5.dp, end = 5.dp)
            .fillMaxSize()
    ) {
        Column {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .height(250.dp)
            )
            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = character.title, fontWeight = FontWeight.Bold)
                Text(text = character.description, maxLines = 2, overflow = TextOverflow.Ellipsis)
            }
        }
    }
}