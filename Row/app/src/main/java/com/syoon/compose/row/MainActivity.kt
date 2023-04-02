package com.syoon.compose.row

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
import com.syoon.compose.row.ui.theme.RowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RowTheme {
                RowEx()
            }
        }
    }
}

@Composable
fun RowEx() {
    Row(modifier = Modifier.height(40.dp)) {
        Text(text = "첫 번째!")
        Text(text = "두 번째!")
        Text(text = "세 번째!")
    }

    // Step1 : 각 Text의 modifier에 align 설정
    Row(modifier = Modifier.height(40.dp)) {
        Text(text = "첫 번째!", modifier = Modifier.align(Alignment.Top))
        // rowScope의 align에서는 Center를 쓸 수 없다
        // Center면 Vertically인지 Horizontally인지 모르기 때문
        Text(text = "두 번째!", modifier = Modifier.align(Alignment.CenterVertically))
        Text(text = "세 번째!", modifier = Modifier.align(Alignment.Bottom))
    }

    // Step2 : Row에 verticallyAlignMent 설정
    Row(
        modifier = Modifier.height(40.dp),
        verticalAlignment = Alignment.Bottom // Row align 전체 적용
    ) {
        Text(text = "첫 번째!", modifier = Modifier.align(Alignment.Top)) // align 부분 적용
        Text(text = "두 번째!")
        Text(text = "세 번째!")
    }

    // Step3 : Row에 width 200dp 설정 및 horizontalArrangement 설정
    Column {
        // Center
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .width(200.dp)
                .height(40.dp),
            verticalAlignment = Alignment.Bottom, // Row align 전체 적용

        ) {
            Text(text = "첫 번째!", modifier = Modifier.align(Alignment.Top)) // align 부분 적용
            Text(text = "두 번째!")
            Text(text = "세 번째!")
        }

        // SpaceAround
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .width(200.dp)
                .height(40.dp),
            verticalAlignment = Alignment.Bottom, // Row align 전체 적용

        ) {
            Text(text = "첫 번째!", modifier = Modifier.align(Alignment.Top)) // align 부분 적용
            Text(text = "두 번째!")
            Text(text = "세 번째!")
        }

        // SpaceBetween
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .width(200.dp)
                .height(40.dp),
            verticalAlignment = Alignment.Bottom, // Row align 전체 적용

        ) {
            Text(text = "첫 번째!", modifier = Modifier.align(Alignment.Top)) // align 부분 적용
            Text(text = "두 번째!")
            Text(text = "세 번째!")
        }

        // SpaceEvenly
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .width(200.dp)
                .height(40.dp),
            verticalAlignment = Alignment.Bottom, // Row align 전체 적용

        ) {
            Text(text = "첫 번째!", modifier = Modifier.align(Alignment.Top)) // align 부분 적용
            Text(text = "두 번째!")
            Text(text = "세 번째!")
        }
    }

    // Step4 : horizontalArrangement를 제거하고 각 Text에 Modifier.weight 설정
    Row(
        modifier = Modifier
            .width(200.dp)
            .height(40.dp),
        verticalAlignment = Alignment.Bottom, // Row align 전체 적용

    ) {
        Text(
            text = "첫 번째!",
            modifier = Modifier
                .align(Alignment.Top)
                .weight(3f)
                .background(Color.Magenta)
        )
        Text(
            text = "두 번째!",
            modifier = Modifier.weight(2f).background(Color.Cyan)
        )
        Text(
            text = "세 번째!",
            modifier = Modifier.weight(3f).background(Color.Blue)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RowTheme {
        RowEx()
    }
}