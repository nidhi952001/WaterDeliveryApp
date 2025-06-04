package com.example.waterdeliveryapp.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.waterdeliveryapp.uiScreen.TopBarScreen.topBarWithLeadingArrow
import com.example.waterdeliveryapp.utils.HomeScreenUIState
import com.example.waterdeliveryapp.utils.NavigationScreenName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel:ViewModel() {

    private val _homeUiState = MutableStateFlow(HomeScreenUIState())
    val homeUiState = _homeUiState.asStateFlow()


}