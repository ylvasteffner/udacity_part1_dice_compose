package com.example.diceincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceincompose.ui.theme.DiceInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceInComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Dice()
                }
            }
        }
    }
}


@Composable
fun Dice() {

    var imageSetter = remember {
        mutableStateOf(R.drawable.empty_dice)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 30.dp, bottom = 20.dp, end = 30.dp)
    ) {
        Image(
            painter = painterResource(id = imageSetter.value),
            contentDescription = "Image of dice",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        )
        Button(
            onClick = { imageSetter.value = rollDice() },
        ) {
            Text(
                text = "Roll the dice")
        }
    }

}



private fun rollDice(): Int {
    val randomInt = java.util.Random().nextInt(6) + 1
    val drawableResource = when (randomInt) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    return drawableResource
    //buttonText = "You rolled the dice"
    //diceImage.setImageResource(drawableResource)
}


//@Composable
//fun ChangeText() {
//    var text by remember { mutableStateOf("Roll the dice") }
//
//    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
//        Text(text)
//
//        Button(onClick = { text = "Button 1 Clicked" }) {
//            Text(text = "Button 1")
//        }
//        Button(onClick = { text = "Button 2 Clicked" }) {
//            Text(text = "Button 2")
//        }
//        Button(onClick = { text = "Button 3 Clicked" }) {
//            Text(text = "Button 3")
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DiceInComposeTheme {
        Dice()
    }
}