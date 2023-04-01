package com.syoon.compose.modifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
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
                //ModifierEx()
                // TextWithWarning1(Modifier) {} // error : name 매개변수 없이 정의 불가능
                TextWithWarning1("",Modifier) {} // name의 초기화가 무조건 진행되어야 함
                TextWithWarning1(modifier = Modifier) {} // name을 생략하고 싶으면 modifier(매개변수 이름) 명시

                TextWithWarning2(Modifier.background(Color.Magenta)) {} // name 매개변수 생략 가능

                TextWithWarning3(modifier = Modifier.background(Color.Yellow), callback = {}) // 마지막 파라미터가 함수여야 후행람다식 가능
            }
        }
    }
}

@Composable
fun TextWithWarning1(
    // 매개변수의 기본값이 있는 경우 호출자는 선택적으로 사용할 수 있다
    // 그러나 첫 번째 매개변수인 경우 생략할 수 없다 (생략하려면 매개변수 이름을 명시해야 함)
    name: String = "Default",
    modifier: Modifier,
    callback: () -> Unit,
) {
    Text(text = "TextWithWarning1! $name", modifier = modifier
        .background(Color.Yellow)
        .clickable { callback.invoke() })
}

@Composable
fun TextWithWarning2(
    modifier: Modifier,
    name: String = "",
    callback: () -> Unit,
) {
    Text(text = "TextWithWarning2! $name", modifier = modifier
        .background(Color.Yellow)
        .clickable { callback.invoke() })
}

@Composable
fun TextWithWarning3(
    modifier: Modifier,
    callback: () -> Unit,
    name: String = "",
) {
    Text(text = "TextWithWarning3! $name", modifier = modifier
        .background(Color.Yellow)
        .clickable { callback.invoke() })
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
        contentPadding = PaddingValues(0.dp),
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
        Text(text = "Search") // Text에 별도의 color값을 주면 text만 색이 변경됨
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