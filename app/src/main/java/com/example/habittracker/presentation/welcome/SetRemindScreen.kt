package com.example.habittracker.presentation.welcome

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habittracker.R
import com.example.habittracker.presentation.common.BackButtonImage
import com.example.habittracker.presentation.common.RoundedLinearProgressIndicator
import com.example.habittracker.ui.theme.HabitTrackerTheme

@Composable
fun SetRemindScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BackButtonImage(start = 20.dp, top = 16.dp)
                Text(
                    text = "2/3",
                    fontSize = 25.sp,
                    color = colorResource(id = R.color.white),
                    modifier = Modifier.padding(end = 16.dp, top = 11.dp)
                )
            }
            RoundedLinearProgressIndicator(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .fillMaxWidth()
                    .size(15.dp, 20.dp)
                    .padding(top = 10.dp, start = 20.dp, end = 16.dp), // Rounded edges
                color = colorResource(id = R.color.dark_gray),
                trackColor = colorResource(id = R.color.gray),
                progress = 0.70f
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = "When do you want us to remind you?",
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.white),
                    modifier = Modifier
                        .width(LocalConfiguration.current.screenWidthDp.dp / 2 + 120.dp)
                        .padding(start = 20.dp, top = 26.dp)
                )
                SetTimes(
                    listOf(
                        Dates("Morning","6:00AM"),
                        Dates("Noon","12:00PM"),
                        Dates("Evening","6:00PM"),
                    )
                )
            }
        }
        TextButton(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                Color.Transparent,
                colorResource(id = R.color.white)
            ),
            modifier = Modifier
                .clip(RoundedCornerShape(40))
                .padding(start = 16.dp, end = 16.dp, top = 60.dp, bottom = 20.dp)
                .align(Alignment.BottomStart)
                .width(LocalConfiguration.current.screenWidthDp.dp / 2 - 30.dp),
            contentPadding = PaddingValues(20.dp),
            border = BorderStroke(1.dp, Color.White)
        ) {
            Text(
                text = "Skip",
                fontSize = 19.sp,
            )

        }
        TextButton(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                colorResource(id = R.color.red),
                colorResource(id = R.color.white)
            ),
            modifier = Modifier
                .clip(RoundedCornerShape(40))
                .padding(start = 16.dp, end = 16.dp, top = 60.dp, bottom = 20.dp)
                .align(Alignment.BottomEnd)
                .width(LocalConfiguration.current.screenWidthDp.dp / 2 - 30.dp),
            contentPadding = PaddingValues(20.dp),
        ) {
            Text(
                text = "Proceed",
                fontSize = 19.sp,
            )
        }
    }
}

@Composable
fun SetTimes(
    list: List<Dates>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .height(LocalConfiguration.current.screenHeightDp.dp),

        contentPadding = PaddingValues(15.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(list) { it ->
            TimeBox(it)
        }
    }
}

@Composable
fun TimeBox(habit: Dates) {
    val selected = remember { mutableStateOf(false) }
    val color =
        if (selected.value) Color.Transparent else colorResource(id = R.color.lighter_background)
    val borderColor = if (!selected.value) Color.Transparent else colorResource(id = R.color.red)
    Column(
        modifier = Modifier
            .width(LocalConfiguration.current.screenWidthDp.dp / 3)
            .height(200.dp)
            .clip(RoundedCornerShape(20))
            .pointerInput(Unit) {}
            .clickable {
                selected.value = !selected.value
            }
            .border(2.dp, color = borderColor, RoundedCornerShape(20))
            .background(color = color),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = habit.time,
            color = colorResource(id = R.color.white),
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 10.dp)
        )
        Text(
            text = habit.dateTime,
            color = colorResource(id = R.color.gray),
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

@Preview
@Composable
fun TimeboxPreview() {
    HabitTrackerTheme() {
        TimeBox(habit = Dates("Evening","6:00AM"))
    }
}

data class Dates(
    val dateTime: String,
    val time: String,
)

@Composable
@Preview
fun SetRemindScreenPreview() {
    HabitTrackerTheme {
        SetRemindScreen()
    }
}
