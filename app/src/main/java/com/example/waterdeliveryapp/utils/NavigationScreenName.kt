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
    REGISTRATION_SCREEN(route = R.string.registration_screen)
}