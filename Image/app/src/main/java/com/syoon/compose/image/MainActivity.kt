package com.syoon.compose.image

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.syoon.compose.image.ui.theme.ImageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageTheme {
                ImageEx()
            }
        }
    }
}

@Composable
fun ImageEx() {
    Column {
        // Step1 : Image 만들기
        Image(
            painter = painterResource(id = R.drawable.wall),
            contentDescription = "엔텔로프 캐넌"
        )

        // Step2 : ImageVector에 Incons.Filled.Settings를 설정
        Image(
            imageVector = Icons.Filled.Settings,
            contentDescription = "세팅"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ImageTheme {
        ImageEx()
    }
}