package com.example.waterdeliveryapp.uiScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.waterdeliveryapp.R


@Composable
fun ProductScreenRoute(){
    Column(modifier = Modifier.fillMaxWidth().background(color = MaterialTheme.colorScheme.onPrimary).padding(horizontal = 10.dp, vertical = 20.dp)) {
        Row(modifier = Modifier.fillMaxWidth() , verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = stringResource(R.string.drips_purified_water),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(text = stringResource(R.string.available_in_stock),
                color = MaterialTheme.colorScheme.outline,
                fontSize = 14.sp)
        }
        Text(text = stringResource(R.string.hundred),
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Light,
            fontSize = 19.sp
        )
        Text(text = stringResource(R.string.delivery_desc),
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Light,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Justify,
            fontSize = 15.sp,
            modifier = Modifier.padding(top = 10.dp, end = 20.dp))
        Row(modifier = Modifier.fillMaxWidth().padding(top = 10.dp) , verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = stringResource(R.string.shopping_cart),
                tint = Color(0xFFFEC54B),
                modifier = Modifier.size(30.dp)
            )
            Text(text = "4.5",
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Text(text = stringResource(R.string.review),
                color = MaterialTheme.colorScheme.outline,
                fontWeight = FontWeight.Light,
                fontSize = 15.sp
            )
        }
        Row(modifier = Modifier.fillMaxSize().padding(top = 15.dp) , verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                Column {
                    Text(text = stringResource(R.string.bottle_size),
                        color = MaterialTheme.colorScheme.onSurface,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                    Row(modifier = Modifier.border(width = 1.dp, color = MaterialTheme.colorScheme.inversePrimary , shape = RoundedCornerShape(5.dp))) {
                        Text(
                            text = "50Ml",
                            color = MaterialTheme.colorScheme.onSurface,
                            fontWeight = FontWeight.Light,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(5.dp)
                        )
                        Icon(imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "arrow_down",
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.background(color = MaterialTheme.colorScheme.inversePrimary))
                    }
                }
            Column {
                Text(text = stringResource(R.string.quantity),
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Row {
                    Icon(imageVector = Icons.Filled.Add,
                        contentDescription = "arrow_down",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.background(color = MaterialTheme.colorScheme.outlineVariant))
                    Text(
                        text = "1",
                        color = MaterialTheme.colorScheme.onSurface,
                        fontWeight = FontWeight.Light,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(5.dp)
                    )
                    Icon(imageVector = Icons.Filled.Add ,
                        contentDescription = "arrow_down",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.background(color = MaterialTheme.colorScheme.outline))
                }
            }
        }

        Button(
            onClick = {}
        ){
            Text(text = "Buy")
        }
    }
}