package com.example.composedicerollerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedicerollerapp.ui.theme.ComposeDiceRollerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDiceRollerAppTheme {
                DiceRollApp()
            }

        }
    }
}

@Composable
fun DiceRollApp() {
    var number by remember { mutableStateOf(1) }

    val imageResource = when (number) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = imageResource), contentDescription = null)
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        )
        Button(onClick = {
            number = (1..6).random()

        }) {
            Text(text = "Roll")
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DiceRollAppPreview() {
    DiceRollApp()
}

