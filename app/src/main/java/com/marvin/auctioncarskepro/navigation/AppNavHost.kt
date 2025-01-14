package com.marvin.auctioncarskepro.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marvin.auctioncarskepro.dashboard.AddCarScreen
import com.marvin.auctioncarskepro.dashboard.HomeScreen
import com.marvin.auctioncarskepro.dashboard.LoginScreen
import com.marvin.auctioncarskepro.dashboard.RegistrationScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier,
               navHostController:NavHostController = rememberNavController(),
               startDestination:String = LOGIN_URL){
    NavHost(navController = navHostController,startDestination = startDestination,modifier=modifier){
        composable(HOME_URL){
            HomeScreen(navHostController)
        }

        composable(REGISTER_URL) {
            RegistrationScreen(navHostController)
        }

        composable(LOGIN_URL){
            LoginScreen(navHostController)
        }

        composable(ADD_CARS_URL) {
            AddCarScreen(navHostController)
        }

    }
}






