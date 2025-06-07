package com.example.waterdeliveryapp.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.waterdeliveryapp.R

data class WaterData(
    @DrawableRes val image:Int,
    @StringRes val description:Int,
    @StringRes val price:Int
)

object homeScreenData {
    var list = listOf(
        WaterData(R.drawable.springwater,R.string.drips_spring_water,R.string.hundred),
        WaterData(R.drawable.distiledwater,R.string.drips_distilled_water,R.string.hundred),
        WaterData(R.drawable.springwater_2,R.string.drips_spring_water,R.string.hundred_fifty),
        WaterData(R.drawable.purifiedwater,R.string.drips_purified_water,R.string.two_hundred),
    )

}