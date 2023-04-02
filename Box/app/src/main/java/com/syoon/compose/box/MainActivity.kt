package com.syoon.compose.box

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.syoon.compose.box.ui.theme.BoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BoxEx()
                }
            }
        }
    }
}

@Composable
fun BoxEx() {
    Column() {
        Box(modifier = Modifier.size(100.dp)) {
            Text(text = "Hello World!", modifier = Modifier.align(Alignment.Center))
        }

        // Step1 : Text 2개를 Box 내에 배치
        // 여러개의 항목을 겹쳐서 배치할 수 있음
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Yellow)
        ) {
            // Modifier.align : BoxScope의 확장함수로 BoxScope 내에서만 사용 가능
            Text(text = "Hello World!", modifier = Modifier.align(Alignment.BottomEnd))
            Text(text = "Jetpack", modifier = Modifier.align(Alignment.CenterEnd))
            Text(text = "Compose", modifier = Modifier.align(Alignment.TopStart))
        }

        // Step2 : 2개의 Box를 Box 내부에 배치
        Box(modifier = Modifier.size(100.dp)) {
            Box(modifier = Modifier
                .size(70.dp)
                .background(Color.Cyan)
                .align(Alignment.CenterStart))
            Box(modifier = Modifier
                .size(70.dp)
                .background(Color.Yellow)
                .align(Alignment.BottomEnd))
        }
    }

    // Step3 : 부모 Box에 modifier 설정을 제거해서 콘텐트 사이즈만큼 보여주기
    // matchParentSize() 설정 : BoxScope 확장함수
    Box { // 1. 부모는 70 사이즈로 지정된 두 번째 Box의 크기로 설정됨
        Box(modifier = Modifier
            .matchParentSize() // 2. 부모 사이즈에 맞추면 70.dp가 되면서 두 번째 Box에 가려짐
            .background(Color.Cyan)
            .align(Alignment.CenterStart))
        Box(modifier = Modifier
            .size(70.dp)
            .background(Color.Yellow)
            .align(Alignment.BottomEnd))
    }

    // Step3-1 : 부모 Box에 modifier 설정을 제거해서 콘텐트 사이즈만큼 보여주기
    // fillMaxSize() 설정
    Box { // 1. 부모는 fillMaxSize()인 전체 사이즈로 설정됨
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
            .align(Alignment.CenterStart))
        Box(modifier = Modifier
            .size(70.dp)
            .background(Color.Yellow)
            .align(Alignment.BottomEnd))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BoxTheme {
        BoxEx()
    }
}