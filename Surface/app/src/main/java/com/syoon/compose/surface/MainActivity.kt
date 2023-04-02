package com.syoon.compose.surface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.syoon.compose.surface.ui.theme.SurfaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SurfaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column() {
        Surface(
            color = MaterialTheme.colorScheme.surface,
            modifier = Modifier
                .padding(5.dp)
        ) {
            Text(
                text = "Hello $name!", modifier = Modifier
                    .background(Color.Yellow)
                    .padding(8.dp)
            )
        }

        // Step1 : Surfae에 elevation 설정
        Surface(
            shadowElevation = 5.dp, // M2에서 elevation
            modifier = Modifier.padding(5.dp)
        ) {
            Text(
                text = "Hello $name!", modifier = Modifier
                    .background(Color.Yellow)
                    .padding(8.dp)
            )
        }

        // Step2 : border 값 설정
        Surface(
            border = BorderStroke(
                width = 2.dp,
                color = Color.Magenta
            ),
            modifier = Modifier.padding(5.dp)
        ) {
            Text(
                text = "Hello $name!", modifier = Modifier
                    .background(Color.Yellow)
                    .padding(8.dp)
            )
        }

        // Step3 : Surface의 shape 설정
        Surface(
            border = BorderStroke(
                width = 2.dp,
                color = Color.Magenta
            ),
            modifier = Modifier.padding(5.dp),
            shape = CircleShape
        ) {
            Text(
                text = "Hello $name!", modifier = Modifier
                    .background(Color.Yellow)
                    .padding(8.dp)
            )
        }

        // Step4 : color 지정
        Surface(
            border = BorderStroke(
                width = 2.dp,
                color = Color.Magenta
            ),
            modifier = Modifier.padding(5.dp),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.secondary,
            //contentColor = Color.Black
        ) {
            Text(
                text = "Hello $name!", modifier = Modifier
                    .padding(8.dp)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SurfaceTheme {
        Greeting("Android")
    }
}