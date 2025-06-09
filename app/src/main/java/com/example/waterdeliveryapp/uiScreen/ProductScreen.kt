package com.example.waterdeliveryapp.uiScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.waterdeliveryapp.R

@Composable
fun ProductScreenRoute(){
    Column(modifier = Modifier.fillMaxWidth().background(color = MaterialTheme.colorScheme.onPrimary).padding(horizontal = 20.dp)) {
        Row(modifier = Modifier.fillMaxWidth() , horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = stringResource(R.string.drips_purified_water)
            )
            Text(text = stringResource(R.string.available_in_stock))
        }
        Text(text = stringResource(R.string.hundred))
        Text(text = stringResource(R.string.delivery_desc))
    }
}