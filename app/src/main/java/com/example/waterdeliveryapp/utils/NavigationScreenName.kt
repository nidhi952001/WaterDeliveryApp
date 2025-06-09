package com.example.waterdeliveryapp.utils

import androidx.annotation.StringRes
import androidx.compose.ui.res.stringResource
import com.example.waterdeliveryapp.R

enum class NavigationScreenName(
    @StringRes val route:Int
){
    SPLASH_SCREEN(route = R.string.splash_screen),
    ONBOARDING_SCREEN(route = R.string.on_boarding_screen),
    WELCOME_SCREEN(route = R.string.welcome_screen),
    LOGIN_SCREEN(route = R.string.login_screen),
    REGISTRATION_SCREEN(route = R.string.registration_screen),
    HOME_USER_SCREEN(route = R.string.home_user_screen),
    CART_SCREEN(route = R.string.shopping_cart),
    FAVOURITE_SCREEN(route = R.string.favourite),
    MY_PROFILE_SCREEN(route = R.string.profile),
    PRODUCT_SCREEN(route = R.string.product)
}