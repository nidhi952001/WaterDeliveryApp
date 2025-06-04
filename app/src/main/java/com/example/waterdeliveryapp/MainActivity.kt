package com.example.waterdeliveryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.waterdeliveryapp.ui.theme.WaterDeliveryAppTheme
import com.example.waterdeliveryapp.uiScreen.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WaterDeliveryAppTheme {
                AppNavigation()
            }
        }
    }
}

