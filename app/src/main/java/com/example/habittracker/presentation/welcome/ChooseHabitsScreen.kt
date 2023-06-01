package com.example.habittracker.presentation.welcome

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habittracker.R
import com.example.habittracker.presentation.common.RoundedLinearProgressIndicator
import com.example.habittracker.ui.theme.HabitTrackerTheme

@Composable
fun ChooseHabitsScreen() {
    ChooseHabitsScreen("")
}

@Composable
fun ChooseHabitsScreen(
    string: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background)),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_left),
                contentDescription = null,
                modifier = Modifier.padding(start = 20.dp, top = 16.dp)
            )
            Text(
                text = "1/3",
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
            progress = 0.33f
        )
        Column(
//            modifier =Modifier.verticalScroll(rememberScrollState())
        ) {

            Text(
                text = "What habits do you want to work on?",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white),
                modifier = Modifier
                    .width(LocalConfiguration.current.screenWidthDp.dp / 2 + 100.dp)
                    .padding(start = 20.dp, top = 26.dp)
            )
            Text(
                text = "Choose one or more habits.",
                fontSize = 16.sp,
                color = colorResource(id = R.color.gray),
                modifier = Modifier
                    .padding(start = 20.dp, top = 10.dp)
            )
            Box(
                contentAlignment = Alignment.BottomCenter,

                ){
                Habits(
                    listOf(
                        Habit("Workout", R.drawable.dumbbell_svgrepo_com),
                        Habit("Read more", R.drawable.book_open_svgrepo_com),
                        Habit("Take pictures", R.drawable.camera_svgrepo_com),
                        Habit("Planning", R.drawable.simple_calendar_svgrepo_com),
                        Habit("Go to bed", R.drawable.bed_svgrepo_com),
                        Habit("Workout", R.drawable.dumbbell_svgrepo_com),
                        Habit("Workout", R.drawable.dumbbell_svgrepo_com),
                    )
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextButton(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            Color.Transparent,
                            colorResource(id = R.color.white)
                        ),
                        modifier = Modifier
                            .clip(RoundedCornerShape(40))
                            .padding(start = 16.dp, end = 16.dp, top = 60.dp, bottom = 20.dp)
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
        }
    }
}

@Composable
fun Habits(
    habits: List<Habit>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 50.dp),

        contentPadding = PaddingValues(15.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(habits) { it ->
            HabitBox(it)
        }
    }
}

@Composable
fun HabitBox(habit: Habit) {

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
        Image(
            painter = painterResource(id = habit.image),
            contentDescription = null,
            modifier = Modifier.height(80.dp)
        )
        Text(
            text = habit.name,
            color = colorResource(id = R.color.gray),
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 10.dp)
        )
    }

}

@Preview
@Composable
fun HabitboxPreview() {
    HabitTrackerTheme() {
        HabitBox(habit = Habit("workout", R.drawable.dumbbell_svgrepo_com))
    }
}


@Preview
@Composable
fun ChooseHabitsScreenPreview() {
    HabitTrackerTheme {
        ChooseHabitsScreen(string = "")
    }
}

data class Habit(
    val name: String,
    val image: Int
)