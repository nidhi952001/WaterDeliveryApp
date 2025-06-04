package com.example.waterdeliveryapp.ui.theme

import android.annotation.SuppressLint
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.waterdeliveryapp.R


val poppinsMediumFamily = FontFamily(
    Font(R.font.poppin_medium,FontWeight.Medium),
)

val interMediumFamily = FontFamily(
    Font(R.font.inter_semibold,FontWeight.Medium)
)

val poppinsLightFamily = FontFamily(
    Font(R.font.poppin_light,FontWeight.Light)
)

// Set of Material typography styles to start with
@SuppressLint("ResourceAsColor")
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = interMediumFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 44.sp,
        lineHeight = 25.sp,
        letterSpacing = 0.5.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = poppinsMediumFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 34.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = poppinsMediumFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 28.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleSmall = TextStyle(
        fontFamily = poppinsLightFamily,
        fontWeight = FontWeight.Light,
        fontSize = 20.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    // Other default text styles to override ,
)