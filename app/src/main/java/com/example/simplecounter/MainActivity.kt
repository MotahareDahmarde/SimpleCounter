package com.example.simplecounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplecounter.ui.theme.SimpleCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleCounterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var number by remember {
                        mutableStateOf(0)
                    }
                    Column(modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                        ) {
                        TextResult(text = "$number")
                        Row (modifier = Modifier.width(300.dp),
                            horizontalArrangement = Arrangement.SpaceAround
                            ){
                            MyButton(text = "+") {number++}
                            MyButton(text = "-") {
                                if (number > 0) number--
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TextResult( text : String){
    Text(text = text,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold
        )
}

@Composable
fun MyButton(text: String, onButtonClicked:()->Unit){
    Button(onClick = onButtonClicked) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SimpleCounterTheme {
        
    }
}