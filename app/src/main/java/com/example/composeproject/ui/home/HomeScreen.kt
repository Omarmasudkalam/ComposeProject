package com.example.composeproject.ui.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.composeproject.domain.ProductItem
import com.example.composeproject.navigation.Screen

/**
 * Created by OMK on 11/01/23.
 */

@Composable
fun HomeScreen(navController: NavController) {
    val homeViewModel: HomeViewModel = hiltViewModel()
    val products by homeViewModel.characters.collectAsState()

    LazyColumn {

        items(products) { character: ProductItem ->
            productCard(product = character, navController = navController)
        }
    }
}

@Composable
fun productCard(navController: NavController, product: ProductItem) {

    val image = rememberAsyncImagePainter(model = product.image)
    Spacer(modifier = Modifier.height(20.dp))
    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp, start = 5.dp, end = 5.dp)
            .fillMaxSize()
            .clickable {
                navController.navigate(route = "${Screen.DetailScreen.route}?category=${product.category} description=${product.description} id=${product.id} image=${product.image} price=${product.price} title=${product.title}")
            }

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
                Text(text = product.title, fontWeight = FontWeight.Bold)
                Text(text = product.price.toString(), maxLines = 2)
            }
        }
    }
}
