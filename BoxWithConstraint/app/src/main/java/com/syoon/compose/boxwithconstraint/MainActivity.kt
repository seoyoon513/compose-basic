package com.syoon.compose.boxwithconstraint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.syoon.compose.boxwithconstraint.ui.theme.BoxWithConstraintTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxWithConstraintTheme {
                Outer()
            }
        }
    }
}

@Composable
fun Outer() {
    Column(
        // Step4 : 부모 layout에 제약 추가
        modifier = Modifier
            .width(300.dp)
            .background(Color.Yellow)
    ) {
        // Step2 : Inner의 인지로 Modifier.widthIn(min = 100.dp) 설정
        Inner(
            modifier = Modifier
                .widthIn(min = 100.dp, max = 350.dp) // max를 392이상으로 쓸 수 없다
                .heightIn(min = 100.dp, max = 140.dp)
                .background(Color.Magenta)
        )

        Inner(
            modifier = Modifier
                .width(200.dp) // max를 392이상으로 쓸 수 없다
                .height(200.dp)
                .background(Color.Cyan)
        )
    }
}

// Step1 : Inner 인자로 modifier 전달. 기본값을 Modifier로 지정
@Composable
fun Inner(modifier: Modifier = Modifier) {
    BoxWithConstraints(modifier) {
        // Step3 : maxHeight가 150dp 가 넘을 때만 추가로 텍스트 출력
        if (maxHeight > 150.dp) {
            Text(text = "여기 꽤 길군요!", modifier = Modifier.align(Alignment.BottomCenter))
        }

        Text(
            text = "maxW:$maxWidth maxH:$maxHeight minW:$minWidth minH:$minHeight",
            modifier = Modifier
                .fillMaxSize()
                // Step5 : color 제약조건 추가
                //.background(if (maxHeight < 150.dp)Color.Red else Color.Cyan)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BoxWithConstraintTheme {
        Outer()
    }
}