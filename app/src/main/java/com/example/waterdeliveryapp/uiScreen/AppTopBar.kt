package com.example.waterdeliveryapp.uiScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material.icons.sharp.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.waterdeliveryapp.R
import com.example.waterdeliveryapp.utils.NavigationScreenName

@Composable
fun AppTopBar(navController: NavHostController, currentRoute: String?) {
    when (currentRoute) {
        NavigationScreenName.LOGIN_SCREEN.name,
        NavigationScreenName.REGISTRATION_SCREEN.name
        -> {
            topBarWithLeadingArrow(navController = navController)
        }

        NavigationScreenName.HOME_USER_SCREEN.name -> {
            topBarWithSearch()
        }
        NavigationScreenName.PRODUCT_SCREEN.name->{
            ProductScreenTopBar()
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topBarWithLeadingArrow(navController: NavHostController) {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topBarWithSearch() {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.primaryContainer)
                    .padding(horizontal = 10.dp).padding(top = 50.dp, bottom = 10.dp)
            ) {
                Text(
                    text = stringResource(R.string.welcome_back),
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Text(
                    text = stringResource(R.string.name_hint),
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.ExtraBold
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                    value = "",
                    onValueChange = {},
                    placeholder = {
                        Text(
                            text = stringResource(R.string.search),
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = stringResource(R.string.search),
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    },
                    shape = RoundedCornerShape(5.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5F),
                        unfocusedContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5F),
                        focusedBorderColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1F),
                        unfocusedBorderColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1F),
                        cursorColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
}

@Composable
fun ProductScreenTopBar(){
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(R.drawable.springwater_full),
            contentDescription = stringResource(R.string.drips_purified_water),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.5F)
        )
        Icon(
            imageVector = Icons.Sharp.ArrowBack,
            contentDescription = stringResource(R.string.back_arrow),
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.align(Alignment.TopStart)
                .padding(start = 20.dp, top = 50.dp)
        )
        Icon(
            imageVector = Icons.Outlined.Favorite,
            contentDescription = stringResource(R.string.favourite),
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 20.dp, top = 50.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(color = MaterialTheme.colorScheme.onSurface)
                .padding(5.dp)
        )
        Icon(
            imageVector = Icons.Outlined.ShoppingCart,
            contentDescription = stringResource(R.string.shopping_cart),
            tint = MaterialTheme.colorScheme.inversePrimary,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 20.dp, bottom = 20.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(color = MaterialTheme.colorScheme.onPrimary)
                .padding(5.dp)
        )
    }
}

@Composable
@Preview
fun topBarWithSearchPreview(){
    ProductScreenTopBar()
}
