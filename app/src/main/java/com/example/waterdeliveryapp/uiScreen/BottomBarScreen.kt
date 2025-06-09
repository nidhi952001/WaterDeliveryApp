package com.example.waterdeliveryapp.uiScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.waterdeliveryapp.utils.NavigationScreenName
import com.example.waterdeliveryapp.utils.bottomBarDataList

@Composable
fun BottomBarScreen(navController: NavHostController, currentRoute: String?) {
    when (currentRoute) {
        NavigationScreenName.HOME_USER_SCREEN.name ,
        NavigationScreenName.PRODUCT_SCREEN.name-> {
            BottomAppBar(
                modifier = Modifier.fillMaxWidth(),
                containerColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .background(color = MaterialTheme.colorScheme.onPrimary)
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    bottomBarDataList.nav.forEach {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                imageVector = it.image,
                                contentDescription = stringResource(it.description),
                                modifier = Modifier.clickable(onClick = { currentRoute == it.screenName })
                            )
                            if (currentRoute == it.screenName)
                                Box(
                                    modifier = Modifier.size(5.dp).clip(CircleShape)
                                        .background(color = MaterialTheme.colorScheme.primaryContainer)
                                )
                            if(currentRoute == NavigationScreenName.PRODUCT_SCREEN.name){
                                if(it.screenName == NavigationScreenName.HOME_USER_SCREEN.name)
                                    Box(
                                        modifier = Modifier.size(5.dp).clip(CircleShape)
                                            .background(color = MaterialTheme.colorScheme.primaryContainer)
                                    )
                            }

                        }
                    }
                }
            }
        }
    }
}