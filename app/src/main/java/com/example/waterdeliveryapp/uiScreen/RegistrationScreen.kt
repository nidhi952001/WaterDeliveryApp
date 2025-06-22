package com.example.waterdeliveryapp.uiScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.waterdeliveryapp.R

@Composable
fun registrationScreen(){
    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp).padding(bottom = 50.dp),
        verticalArrangement = Arrangement.SpaceBetween) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly) {
            Text(
                text = stringResource(R.string.create_your_account),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primaryContainer,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 25.sp
            )
            Text(
                text = stringResource(R.string.registration_instruction),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.ExtraLight,
                color = MaterialTheme.colorScheme.outline
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text= stringResource(R.string.name),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.outline
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = {Text( stringResource(R.string.name_hint))},
                modifier =  Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    capitalization = KeyboardCapitalization.Words
                )
            )
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
                text= stringResource(R.string.confirm_password),
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
        }
        Column(
            modifier = Modifier.height(IntrinsicSize.Min),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ){
                Text(text = stringResource(R.string.create_an_account),
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(10.dp)
                    )
            }
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                Text(
                    text = stringResource(R.string.already_have_an_account),
                    textDecoration = TextDecoration.Underline
                )
                Text(
                    text = stringResource(R.string.sign_in),
                    textDecoration = TextDecoration.Underline,
                    color = MaterialTheme.colorScheme.primaryContainer,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}