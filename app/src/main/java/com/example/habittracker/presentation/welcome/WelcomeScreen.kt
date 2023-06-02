package com.example.habittracker.presentation.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habittracker.R
import com.example.habittracker.ui.theme.HabitTrackerTheme

@Composable
fun WelcomeScreen() {
    WelcomeScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(
    str: String,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier
            .background(colorResource(id = R.color.background))
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,

        ) {
        Image(
            modifier = Modifier.height(LocalConfiguration.current.screenHeightDp.dp / 2),
            painter = painterResource(id = R.drawable.ic_habit_welcome),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Column {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Habitat",
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .wrapContentSize()
                        .align(Alignment.Center),
                    color = colorResource(id = R.color.white),
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Build habits and routines easily",
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.Center),
                    color = colorResource(id = R.color.gray),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            TextButton(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    colorResource(id = R.color.red),
                    colorResource(id = R.color.white)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(40))
                    .padding(start = 16.dp, end = 16.dp, top = 60.dp, bottom = 20.dp),
                contentPadding = PaddingValues(20.dp)
            ) {
                    Text(
                        text = "Let's start",
                        fontSize = 19.sp,
                    )
            }
            Text(
                text = "Need an account? Sign up here",
                color = colorResource(id = R.color.white),
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    HabitTrackerTheme {
        WelcomeScreen(str = "sda")
    }
}