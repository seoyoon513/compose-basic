package com.syoon.compose.textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.syoon.compose.textfield.ui.theme.TextFieldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {
    var name = ""
    var rememberName by remember { mutableStateOf("") }
    val isError = rememberName == "sy"
    Column(modifier = Modifier.padding(16.dp)) {
        // 일반 변수
        TextField(
            value = name,
            onValueChange = { input -> name = input},
        )
        Spacer(modifier = Modifier.size(20.dp))
        // remember 변수
        OutlinedTextField(
            value = rememberName,
            onValueChange = { input -> rememberName = input },
            isError = isError,
            placeholder= { Text(text = "hint", style = TextStyle(color = Color.Blue))},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Blue,
                focusedBorderColor = Color.Green,
                errorBorderColor = Color.Yellow,
            ),
            supportingText = {Text(text = if (isError) "그건 내 이름이에요" else "")}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Greeting()
}