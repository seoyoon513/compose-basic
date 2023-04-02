package com.syoon.compose.checkbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.syoon.compose.checkbox.ui.theme.CheckBoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckBoxTheme {
                CheckBoxEx()
            }
        }
    }
}

@Composable
fun CheckBoxEx() {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            // Step1 : CheckBox 만들기
            // checked = false의 '상태'가 바뀌어야만 체크표시를 할 수 있다
            Checkbox(checked = false, onCheckedChange = {})
            Text(text = "프로그래머입니까?")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            // Step2 : onCheckedChange에서 boolean값 변수 변경 시도 (체크표시 불가능)
            // 상태를 변경하는 것이 아니기 때문
            var checked = false
            Checkbox(
                checked = checked,
                onCheckedChange = {
                    checked = !checked
                }
            )
            Text(text = "프로그래머입니까?")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            // Step3 : remember { mutableStateOf(false) } 사용하여 상태 도입
            // remember는 jetpackcompose에서 상태를 기억하기 위해 사용
            // 상태가 바뀌면 recomposition이 일어남
            var checked = remember {
                mutableStateOf(false)
            }
            Checkbox(
                checked = checked.value,
                onCheckedChange = {
                    checked.value = !checked.value
                }
            )
            Text(text = "프로그래머입니까?")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            // Step4 : 위임된 속성 사용하기
            // 이 경우 checked를 프로퍼틴인 것 처럼 사용할 수 있음
            var checked by remember { mutableStateOf(false) }
            Checkbox(
                checked = checked,
                onCheckedChange = {
                    checked = !checked
                }
            )
            Text(text = "프로그래머입니까?")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            // Step5 : 비구조화 사용하기
            val (checked, setChecked) = remember {
                mutableStateOf(false)
            }
            Checkbox(
                checked = checked,
                onCheckedChange = {
                    setChecked(it) // it이 주는 값이 반전된 값
                }
            )
            Text(text = "프로그래머입니까?")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            // Step6 : Text를 클릭했을 때도 checkBox 선택되게 만들기
            // Modifier의 clickable 사용
            var checked = remember {
                mutableStateOf(false)
            }
            Checkbox(
                checked = checked.value,
                onCheckedChange = {
                    checked.value = !checked.value
                }
            )
            Text(
                text = "프로그래머입니까?",
                modifier = Modifier.clickable {
                    checked.value = !checked.value
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CheckBoxTheme {
        CheckBoxEx()
    }
}