package com.example.waterdeliveryapp.uiScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.waterdeliveryapp.R
import com.example.waterdeliveryapp.ui.theme.Typography

@Composable
fun welcomeScreen(
    onCreateAccountClick:()->Unit,
    onLoginClick:()->Unit,
    onGuestUserClick:()->Unit
) {
    Box(modifier = Modifier.fillMaxSize().
        paint(
            painter = painterResource(R.drawable.welcome_page_back),
            contentScale = ContentScale.Crop,
            alpha = 0.8F
        )
    ){
        Column {
            Spacer(Modifier.fillMaxSize().weight(1f))
            Column(modifier = Modifier.fillMaxSize().weight(1f).padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(R.string.welcome_txt_title),
                    style = Typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary)
                Text(
                    text = stringResource(R.string.welcome_txt_sub_title),
                    style = Typography.titleSmall,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onPrimary)
                Button(
                    onClick = {onCreateAccountClick()},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    shape = RectangleShape,
                    modifier = Modifier.fillMaxWidth().padding(10.dp)
                ){
                    Text(
                        text = stringResource(R.string.create_an_account).toUpperCase(Locale.current),
                        style = Typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(15.dp)
                    )
                }
                Button(
                    onClick = {onLoginClick()},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    shape = RectangleShape,
                    modifier = Modifier.fillMaxWidth().padding(10.dp),
                    border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.onPrimary)
                ){
                    Text(
                        text = stringResource(R.string.login).toUpperCase(Locale.current),
                        style = Typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.padding(15.dp)
                    )
                }
                Text(
                    text = stringResource(R.string.continue_as_guest),
                    style = Typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(15.dp).clickable(onClick = {onGuestUserClick()})
                )
            }
        }
    }
}

@Composable
@Preview
fun welcomeScreenPreview(){
    welcomeScreen(
        onCreateAccountClick = {},
        onLoginClick = {},
        onGuestUserClick = {})
}