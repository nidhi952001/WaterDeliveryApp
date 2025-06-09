package com.example.waterdeliveryapp.uiScreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColor
import com.example.waterdeliveryapp.R
import com.example.waterdeliveryapp.utils.homeScreenData

@Composable
fun HomeScreenUserRoute() {
    val scrollableState = rememberScrollState(0)
    Column(Modifier.fillMaxSize()
        .verticalScroll(scrollableState)
        .padding(start = 10.dp, end = 10.dp)) {
        sliderPager()
        filterContent()
        content()
    }
}

@Composable
fun sliderPager() {
    val pagerState = rememberPagerState(pageCount = { 2 })
    Row(modifier = Modifier.padding(top = 10.dp)) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(modifier = Modifier.wrapContentWidth().clip(shape = RoundedCornerShape(20.dp))) {
                Image(
                    painter = painterResource(R.drawable.slider),
                    contentDescription = stringResource(R.string.slider),
                    modifier = Modifier.fillMaxWidth().clip(shape = RectangleShape),
                    contentScale = ContentScale.Crop,
                    colorFilter = ColorFilter.tint(
                        color = MaterialTheme.colorScheme.outlineVariant,
                        blendMode = BlendMode.Darken
                    )
                )
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = stringResource(R.string.drips_springs),
                        color = MaterialTheme.colorScheme.surface,
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        text = stringResource(R.string.bottle_water_delivery),
                        color = MaterialTheme.colorScheme.surface,
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = MaterialTheme.typography.bodySmall.fontSize,
                        fontWeight = FontWeight.Normal
                    )
                }
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(
                            LocalContext.current.getResources().getColor(R.color.orange)
                        ),
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.align(Alignment.BottomEnd).padding(10.dp)
                ) {
                    Text(text = "Quick Shop")
                }
            }
        }
    }
    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagerState.pageCount) {
            val color = if (pagerState.currentPage == it)
                MaterialTheme.colorScheme.onSurfaceVariant
            else
                MaterialTheme.colorScheme.outlineVariant
            Box(
                modifier = Modifier.size(height = 10.dp, width = 30.dp)
                    .clip(shape = RoundedCornerShape(5.dp)).background(color = color)
            )
        }
    }
}


@Composable
fun filterContent() {
    Text(
        text = stringResource(R.string.water_type),
        fontWeight = FontWeight.ExtraBold,
        modifier = Modifier.fillMaxWidth()
    )
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween , verticalAlignment = Alignment.CenterVertically) {
        Text(text = stringResource(R.string.all),
            minLines = 1,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.width(80.dp).height(35.dp)
                .background(
                color = MaterialTheme.colorScheme.onSurface
            ).shadow(elevation = 0.dp, shape = RoundedCornerShape(7.dp))
                .clickable { }
                .padding(7.dp),
            textAlign = TextAlign.Center
        )
        Text(text = stringResource(R.string.distilled),
            minLines = 1,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.width(80.dp).height(35.dp).background(
                color = MaterialTheme.colorScheme.onSurface
            ).shadow(elevation = 0.dp, shape = RoundedCornerShape(7.dp))
                .clickable { }.padding(7.dp),
            textAlign = TextAlign.Center
        )
        Text(text = stringResource(R.string.spring),
            minLines = 1,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.width(80.dp).height(35.dp).background(
                color = MaterialTheme.colorScheme.onSurface
            ).shadow(elevation = 0.dp, shape = RoundedCornerShape(7.dp))
                .clickable { }.padding(7.dp),
            textAlign = TextAlign.Center)
        Text(text = stringResource(R.string.purified),
            minLines = 1,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.width(80.dp).height(35.dp).background(
                color = MaterialTheme.colorScheme.onSurface
            ).shadow(elevation = 0.dp, shape = RoundedCornerShape(7.dp))
                .clickable { }.padding(7.dp),
            textAlign = TextAlign.Center)

    }
}

@Composable
fun content() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(7.dp),
        horizontalArrangement = Arrangement.spacedBy(7.dp),
        modifier = Modifier.padding(top = 5.dp).heightIn(max = 2000.dp),
        userScrollEnabled = false
    ) {
        items(homeScreenData.list) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box() {
                    Image(
                        painter = painterResource(it.image),
                        contentDescription = stringResource(it.description),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth().shadow(
                            elevation = 0.dp,
                            shape = RoundedCornerShape(5.dp)
                        )
                    )
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = stringResource(R.string.favourite),
                        modifier = Modifier
                            .padding(3.dp)
                            .align(Alignment.TopEnd)
                            .clip(RoundedCornerShape(6.dp))
                            .background(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.6F))
                            .padding(3.dp)
                    )
                }
                Column(modifier = Modifier.fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface).shadow(
                        0.dp,
                        shape = RoundedCornerShape(7.dp)
                    ).padding(10.dp)) {
                    Text(
                        text = stringResource(it.description),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = MaterialTheme.typography.labelLarge.fontSize
                    )
                    Text(
                        text = stringResource(it.price),
                        fontSize = MaterialTheme.typography.labelLarge.fontSize
                    )
                }
            }
        }

    }
}

@Composable
@Preview
fun Screenpreview() {
    HomeScreenUserRoute()
    //filterContent()
}

