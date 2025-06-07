package com.example.waterdeliveryapp.uiScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.waterdeliveryapp.uiScreen.TopBarScreen.AppTopBar
import com.example.waterdeliveryapp.utils.NavigationScreenName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            AppTopBar(
                navController= navController,
                currentRoute = currentRoute)
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = NavigationScreenName.HOME_USER_SCREEN.name,
            modifier = Modifier.background(color = MaterialTheme.colorScheme.onPrimary).padding(it)
        ) {
            NavGraphBuilder(
                navGraphBuilder = this,
                coroutineScope = coroutineScope,
                navController = navController
            )

        }
    }
}

fun NavGraphBuilder(
    navGraphBuilder: NavGraphBuilder,
    coroutineScope: CoroutineScope,
    navController: NavController
) {
    navGraphBuilder.composable(route = NavigationScreenName.SPLASH_SCREEN.name) {
        spalshScreen(modifier = Modifier.fillMaxSize())
        LaunchedEffect(true) {
            coroutineScope.launch {
                delay(500)
                navController.navigate(NavigationScreenName.ONBOARDING_SCREEN.name)
            }
        }
    }
    navGraphBuilder.composable(route = NavigationScreenName.ONBOARDING_SCREEN.name) {
        OnBoardingScreenRoute(
            onGetStarted = {
                navController.navigate(NavigationScreenName.WELCOME_SCREEN.name)
            }
        )
    }
    navGraphBuilder.composable(route = NavigationScreenName.WELCOME_SCREEN.name){
        welcomeScreen(
            onCreateAccountClick = {},
            onLoginClick = { navController.navigate(NavigationScreenName.LOGIN_SCREEN.name) },
            onGuestUserClick = {  }
        )
    }
    navGraphBuilder.composable(route = NavigationScreenName.LOGIN_SCREEN.name){
        loginScreen()
    }
    navGraphBuilder.composable(route = NavigationScreenName.REGISTRATION_SCREEN.name){
        registrationScreen()
    }
    navGraphBuilder.composable(route = NavigationScreenName.HOME_USER_SCREEN.name){
        HomeScreenUserRoute()
    }
}