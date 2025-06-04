package com.example.waterdeliveryapp.utils

import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import com.example.waterdeliveryapp.uiScreen.BoardingScreenData
import com.example.waterdeliveryapp.uiScreen.boardingData

data class HomeScreenUIState(
    val pagerData:List<BoardingScreenData> = boardingData.data,
)
