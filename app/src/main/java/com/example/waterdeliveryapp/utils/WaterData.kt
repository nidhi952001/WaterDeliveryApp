package com.example.waterdeliveryapp.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.sharp.Favorite
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.waterdeliveryapp.R

data class WaterData(
    @DrawableRes val image:Int,
    @StringRes val description:Int,
    @StringRes val price:Int
)

object homeScreenData {
    var list = listOf(
        WaterData(R.drawable.springwater,R.string.drips_spring_water,R.string.hundred),
        WaterData(R.drawable.distiledwater,R.string.drips_distilled_water,R.string.hundred),
        WaterData(R.drawable.springwater_2,R.string.drips_spring_water,R.string.hundred_fifty),
        WaterData(R.drawable.purifiedwater,R.string.drips_purified_water,R.string.two_hundred),
    )

}

data class BottomBarData(
    val image: ImageVector,
    @StringRes val description: Int,
    val screenName:String
)

object bottomBarDataList{
    var nav = listOf(
        BottomBarData(Icons.Outlined.Home, R.string.home,NavigationScreenName.HOME_USER_SCREEN.name),
        BottomBarData(Icons.Outlined.ShoppingCart,R.string.shopping_cart,NavigationScreenName.CART_SCREEN.name),
        BottomBarData(Icons.Outlined.FavoriteBorder,R.string.favourite,NavigationScreenName.FAVOURITE_SCREEN.name),
        BottomBarData(Icons.Outlined.Person,R.string.profile,NavigationScreenName.MY_PROFILE_SCREEN.name)
    )
}