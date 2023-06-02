package com.example.habittracker.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.habittracker.R

@Composable
fun BackButtonImage(top:Dp = 0.dp,bottom:Dp= 0.dp,start:Dp= 0.dp,end:Dp= 0.dp) {
    Image(
        painter = painterResource(id = R.drawable.ic_arrow_left),
        contentDescription = null,
        modifier = Modifier.padding(top = top, bottom = bottom, start = start, end = end)
    )
}
