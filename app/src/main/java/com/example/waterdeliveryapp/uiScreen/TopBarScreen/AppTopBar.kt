package com.example.waterdeliveryapp.uiScreen.TopBarScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.waterdeliveryapp.utils.NavigationScreenName

@Composable
fun AppTopBar(navController: NavHostController, currentRoute: String?) {
    when(currentRoute){
        NavigationScreenName.LOGIN_SCREEN.name,
        NavigationScreenName.REGISTRATION_SCREEN.name
        ->{
            topBarWithLeadingArrow(navController = navController)
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topBarWithLeadingArrow(navController: NavHostController){
    TopAppBar(
        title = {},
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.inversePrimary,
                modifier = Modifier
                    .clickable(onClick = {
                        navController.navigateUp()
                    }).padding(vertical = 20.dp)
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}


