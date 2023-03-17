package com.syoon.compose.button

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.syoon.compose.button.ui.theme.ButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonTheme {
                ButtonExample(onButtonClicked = {
                    Toast.makeText(this, "Send clicked", Toast.LENGTH_SHORT).show()
                })
            }
        }
    }
}

@Composable
fun ButtonExample(onButtonClicked: () -> Unit) {

    Column {
        // Step1 : Button Click 시 Toast 메세지 띄우기
        Button(onClick = onButtonClicked) {
            Text(text = "Send")
        }

        // Step2 : Text 앞에 아이콘 추가
        Button(onClick = onButtonClicked) {
            Icon(
                imageVector = Icons.Filled.Send,
                contentDescription = null
            )
            Text(text = "Send")
        }

        // Step3 : 아이콘과 Text 사이에 간격 띄우기
        Button(onClick = onButtonClicked) {
            Icon(
                imageVector = Icons.Filled.Send,
                contentDescription = null
            )
            // 기본적으로 제공하는 디폴트 간격 사용 (8.dp)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Send")
        }

        // Step4 : Enabled 설정
        Button(
            onClick = onButtonClicked,
            enabled = false,
        ) {
            Text(text = "Send")
        }

        // Step5 : border에 stroke 설정
        Button(
            onClick = onButtonClicked,
            enabled = true,
            border = BorderStroke(width = 5.dp, color = Color.Blue)
        ) {
            Text(text = "Send")
        }

        // Step6 : shape 설정
        Button(
            onClick = onButtonClicked,
            enabled = true,
            // shape = RoundedCornerShape(size = 10.dp),
            shape = RoundedCornerShape(topEnd = 10.dp)
        ) {
            Text(text = "Send")
        }

        // Step7 : contentPadding 설정
        Button(
            onClick = onButtonClicked,
            enabled = true,
            //contentPadding = PaddingValues(20.dp),
            contentPadding = PaddingValues(horizontal = 5.dp, vertical = 30.dp)
        ) {
            Text(text = "Send")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ButtonTheme {
        ButtonExample(onButtonClicked = {})
    }
}