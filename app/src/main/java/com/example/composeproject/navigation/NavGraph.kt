package com.example.composeproject.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composeproject.ui.details.DetailScreen
import com.example.composeproject.ui.home.HomeScreen


/**
 * Created by OMK on 12/01/2023.
 */

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController= navController,
        startDestination = Screen.HomeScreen.route) {

        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(
            "${Screen.DetailScreen.route}?category={category} description={description} id={id} image={image} price={price} title={title}"
        ) { backStackEntry ->

           val category = backStackEntry.arguments?.getString("category")
            val description = backStackEntry.arguments?.getString("description")
            val id= backStackEntry.arguments?.getInt("id")
            val image= backStackEntry.arguments?.getString("image")
            val price= backStackEntry.arguments?.getDouble("price")
            val title= backStackEntry.arguments?.getString("title")


            DetailScreen(
                category = category!!,
                description = description!!,
                id= id!!,
                image=image!!,
                price = price!!,
                title=title!!,
                navController = navController
            )
        }

    }
}