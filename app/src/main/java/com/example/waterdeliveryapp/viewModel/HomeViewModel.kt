package com.example.waterdeliveryapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.waterdeliveryapp.utils.HomeScreenUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel:ViewModel() {

    private val _homeUiState = MutableStateFlow(HomeScreenUIState())
    val homeUiState = _homeUiState.asStateFlow()


}