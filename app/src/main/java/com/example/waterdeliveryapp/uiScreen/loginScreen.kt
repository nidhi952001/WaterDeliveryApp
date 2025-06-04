package com.example.waterdeliveryapp.uiScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.waterdeliveryapp.R
import com.example.waterdeliveryapp.ui.theme.Typography

@Composable
fun loginScreen(){
    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp).padding(bottom = 50.dp),
        verticalArrangement = Arrangement.SpaceBetween) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly) {
            Text(
                text = stringResource(R.string.welcome_back),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primaryContainer,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 25.sp
            )
            Text(
                text = stringResource(R.string.login_instruction),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.ExtraLight,
                color = MaterialTheme.colorScheme.outline
            )
        }
        Column(
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text= stringResource(R.string.email),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.outline
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = {Text( stringResource(R.string.email_hint))},
                modifier =  Modifier.fillMaxWidth(),
                singleLine = true
            )
            Text(
                text= stringResource(R.string.password),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.outline
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier =  Modifier.fillMaxWidth(),
                singleLine = true,
                placeholder = { Text(stringResource(R.string.password_hint)) },
                visualTransformation = VisualTransformation.None,
                keyboardOptions = KeyboardOptions.Default.copy(
                    capitalization = KeyboardCapitalization.Words
                )
            )
            Text(
                text = stringResource(R.string.forgot_password),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.outline,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Column(
            modifier = Modifier.height(IntrinsicSize.Min),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ){
                Text(text = stringResource(R.string.login),
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(10.dp)
                )
            }
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                Text(
                    text = stringResource(R.string.dont_have_account),
                    textDecoration = TextDecoration.Underline
                )
                Text(
                    text = stringResource(R.string.sign_up),
                    textDecoration = TextDecoration.Underline,
                    color = MaterialTheme.colorScheme.primaryContainer,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}

@Preview
@Composable
fun loginScreenPreview(){
    loginScreen()
}