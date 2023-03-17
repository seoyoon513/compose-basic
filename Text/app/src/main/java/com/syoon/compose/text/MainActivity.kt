package com.syoon.compose.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.syoon.compose.text.ui.theme.TextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TextPractice("Android")
                }
            }
        }
    }
}

@Composable
fun TextPractice(name: String) {

    Column {
        // Step1 : Color.Red로 색상 지정
        Text(color = Color.Red, text = "Hello $name!")

        // Step2 : Color 객체를 이용하여 해쉬값으로 색상 전달 (ARGB 순)
        Text(color = Color(0xffff9944), text = "Hello $name!")

        // Step3 : fontSize 지정
        Text(text = "Hello $name!", fontSize = 20.sp)

        // Step4 : fontWeight 지정
        Text(text = "Hello $name!", fontWeight = FontWeight.Bold)

        // Step5 : fontFamily 지정
        Text(text = "Hello $name!", fontFamily = FontFamily.Cursive)

        // Step6 : letterSpacing 지정
        Text(text = "Hello $name!", letterSpacing = 5.sp)

        // Step7 : maxLine 지정
        Text(
            text = "Hello $name!Hello $name!Hello $name!Hello $name!Hello $name!Hello $name!Hello $name!Hello $name!Hello $name!",
            maxLines = 2,
        )

        // Step8 : testDecoration 지정
        Text(text = "Hello $name!", textDecoration = TextDecoration.LineThrough)

        // Step9 : 정렬
        Text(
            modifier = Modifier.width(300.dp),
            text = "Hello $name!",
            textAlign = TextAlign.End,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TextTheme {
        TextPractice("Android")
    }
}