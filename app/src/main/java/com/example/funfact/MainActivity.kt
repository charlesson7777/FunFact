package com.example.funfact

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfact.ui.theme.FunFactTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FunFactTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    FunFact()
                }

                }
            }
        }
    }

@Composable
fun FunFact(){
    val funFacts = listOf(
        "Dead skin cells are a main ingredient in household dust",
        "Sudan has more pyramids than any country in the world",
        "Avocados are a fruit, not a vegetable.",
        "Human teeth are the only part of the body that cannot heal themselves",
        "Venus is the only planet to spin clockwise.",
        "The longest English word is 189,819 letters long"
    )
    var currentIndex by remember {mutableStateOf(Random.nextInt(funFacts.size))}

    Column(
        modifier = Modifier.fillMaxSize().padding(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
        Text(
            text = funFacts[currentIndex],
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(18.dp).background(Color.Yellow, shape = RoundedCornerShape(10.dp)).padding(10.dp)
        )

        Button(
            onClick = {
                currentIndex = Random.nextInt(funFacts.size)},
            modifier = Modifier.padding(top = 18.dp).width(140.dp).height(60.dp),
            colors = ButtonDefaults.buttonColors(Color.LightGray)

        ){
            Text(
                text = "Next",
                fontSize = 22.sp,
                color = Color.Red,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}




@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

