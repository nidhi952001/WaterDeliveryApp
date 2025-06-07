package com.example.waterdeliveryapp.uiScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.waterdeliveryapp.R
import com.example.waterdeliveryapp.utils.HomeScreenUIState
import com.example.waterdeliveryapp.viewModel.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun spalshScreen(modifier: Modifier) {
    Column(
        modifier = modifier.background(color = MaterialTheme.colorScheme.primaryContainer),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(R.drawable.splash_ic), contentDescription = null)
        Text(
            text = stringResource(R.string.drips_water),
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
fun OnBoardingScreenRoute(onGetStarted:()->Unit) {
    val coroutine = rememberCoroutineScope()
    val homeViewModel:HomeViewModel = hiltViewModel()
    val homeScreenUIState by homeViewModel.homeUiState.collectAsState()
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { boardingData.data.size })
    OnBoardingScreen(Modifier.fillMaxSize(), pagerState, homeScreenUIState, coroutine, onGetStarted)
}

@Composable
private fun OnBoardingScreen(
    modifier: Modifier,
    pagerState: PagerState,
    homeScreenUIState: HomeScreenUIState,
    coroutine: CoroutineScope,
    onGetStarted: () -> Unit
) {
    Column(modifier = modifier.padding(vertical = 30.dp, horizontal = 20.dp)) {
        HorizontalPager(state = pagerState) { page ->
            onBoardingData(
                data = homeScreenUIState.pagerData[page],
                currentPage = page,
                pagerState = pagerState,
                nextPager = {
                    if (pagerState.currentPage < (homeScreenUIState.pagerData.size - 1)) {
                        coroutine.launch {
                            pagerState.scrollToPage(page + 1)
                        }
                    } else {
                        onGetStarted()
                    }
                },
                previousPager = {
                    coroutine.launch {
                        pagerState.scrollToPage(page - 1)
                    }
                }
            )
        }
    }
}


@Composable
fun onBoardingData(
    data: BoardingScreenData,
    currentPage: Int,
    pagerState: PagerState,
    nextPager:()->Unit,
    previousPager:()->Unit
) {
    Column {
        Column(modifier = Modifier.weight(1f),horizontalAlignment = Alignment.CenterHorizontally) {
            pagerBackIcon(pagerState = pagerState , callPreviousPager = previousPager)
            pagerContent(data = data)
            pagerIndication(pagerState = pagerState, currentPage = currentPage)
        }
        Row(verticalAlignment = Alignment.CenterVertically){
            Button(
                onClick = {
                          nextPager()
                },
                modifier = Modifier.fillMaxWidth().requiredHeight(50.dp),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.inversePrimary,
                    contentColor = MaterialTheme.colorScheme.inverseOnSurface
                )
            ){
                Text(
                    text = if(pagerState.currentPage.equals(2))
                        stringResource(R.string.get_started).toUpperCase(Locale.current)
                    else stringResource(R.string.next).toUpperCase(Locale.current),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
@Composable
fun pagerIndication(pagerState: PagerState, currentPage: Int) {
    Row(modifier = Modifier.padding(vertical = 30.dp)){
        repeat(pagerState.pageCount) {
            val color = if(currentPage==it) MaterialTheme.colorScheme.inversePrimary else MaterialTheme.colorScheme.inverseOnSurface
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(color)
                    .width(50.dp)
                    .height(10.dp)
            )
        }
    }
}

@Composable
fun pagerContent(data: BoardingScreenData) {
        Image(
            painter = painterResource(data.image),
            contentDescription = stringResource(data.title)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(data.title),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.light_black_desc)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(data.description),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Light,
            color = colorResource(R.color.light_black_desc)

        )
}
@Composable
fun pagerBackIcon(pagerState: PagerState,callPreviousPager:()->Unit) {
    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp) , horizontalArrangement = Arrangement.End) {
        if(pagerState.currentPage!=0){
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.inversePrimary,
                modifier = Modifier.clickable(onClick = {callPreviousPager()})
            )
        }
    }

}

data class BoardingScreenData(
    val image: Int,
    val title: Int,
    val description: Int
)

object boardingData {
    val data = listOf(
        BoardingScreenData(
            image = R.drawable.leisure_image,
            title = R.string.illustration_title,
            description = R.string.illustration_desc
        ),
        BoardingScreenData(
            image = R.drawable.shopping_image,
            title = R.string.cart_title,
            description = R.string.cart_desc
        ), BoardingScreenData(
            image = R.drawable.delivery_image,
            title = R.string.delivery_title,
            description = R.string.delivery_desc
        )

    )
}
