package com.syoon.compose.modifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.syoon.compose.modifier.ui.theme.ModifierTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModifierTheme {
                ModifierEx()
            }
        }
    }
}

@Composable
fun ModifierEx() {
    // Step1 : Modifier.fillMaxSize() 사용
    Button(
        onClick = {},
        modifier = Modifier.fillMaxSize(fraction = 0.7f) // 속성값 비율
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
        )
        Text(text = "Search")
    }


    // Step2 : Modifier.height 설정
    Button(
        onClick = {},
        modifier = Modifier.height(100.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
        )
        Text(text = "Search")
    }

    // Step3 : Modifier에 height, width 설정
    Button(
        onClick = {},
        modifier = Modifier
            .height(100.dp)
            .width(200.dp) // chaining 방식으로 설정
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
        )
        Text(text = "Search")
    }

    // Step4 : size에 인자로 width, height 전달
    Button(
        onClick = {},
        modifier = Modifier.size(width = 300.dp, height = 50.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
        )
        Text(text = "Search")
    }

    // Step5 : modifier 속성으로 background 설정
    Button(
        onClick = {},
        modifier = Modifier.background(color = Color.Green) // 버튼 바깥쪽 기본 패딩값의 색이 바뀜
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
        )
        Text(text = "Search")
    }

    // Step6 : color 속성으로 background 설정
    Button(
        onClick = {},
        // 해당 속성을 사용해야 버튼의 색을 변경할 수 있음
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue, // M2에서의 속성 이름은 backgroundColor
            contentColor = Color.Red,
        )
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
        )
        Text(text = "Search")
    }

    // Step7 : modifier에 padding 추가
    Button(
        onClick = {},
        modifier = Modifier
            .size(200.dp, 200.dp) // 1. width, height modifier에서
            .background(color = Color.Magenta)
            .padding(horizontal = 10.dp) // 2. horizontal padding값을 준다
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
        )
        Text(text = "Search")
    }

    // Step8 : Button enabled = false, Text modifier에 clickable 넣기
    Button(
        onClick = {},
        enabled = false
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
        )
        Text(
            modifier = Modifier.clickable { // text 영역만 클릭이벤트가 발생한다
                println("click")
            },
            text = "Search",
        )
    }

    // Step9 : Modifier에 offset 설정
    Button(
        onClick = {},
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
        )
        Text(
            modifier = Modifier.offset(x = (-10).dp), // 지정한 픽셀 수만큼 상하좌우로 이동
            text = "Search",
        )
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ModifierTheme {
        ModifierEx()
    }
}