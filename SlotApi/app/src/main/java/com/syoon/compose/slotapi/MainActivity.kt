package com.syoon.compose.slotapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.syoon.compose.slotapi.ui.theme.SlotApiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SlotApiTheme {
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

@Composable
fun CheckBoxWithText(
    checked: MutableState<Boolean>,
    title: String,
    content: @Composable () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            checked.value = !checked.value
        }
    ) {
        Checkbox(
            checked = checked.value,
            onCheckedChange = { checked.value = it }
        )
        Text(
            text = title,
            modifier = Modifier.clickable { checked.value = !checked.value }
        )
        content()
    }
}

@Composable
fun CheckBoxWithText2(
    checked: MutableState<Boolean>,
    title: String,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            checked.value = !checked.value
        }
    ) {
        Checkbox(
            checked = checked.value,
            onCheckedChange = { checked.value = it }
        )
        Text(
            text = title,
            modifier = Modifier.clickable { checked.value = !checked.value }
        )
        content()
    }
}

@Composable
fun CheckBoxWithText3(
    checked: Boolean,
    onCheckChanged: () -> Unit,
    title: String,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            onCheckChanged()
        }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckChanged() }
        )
        Text(
            text = title,
            modifier = Modifier.clickable { onCheckChanged() }
        )
        content()
    }
}


@Composable
fun Greeting() {
    val checked1 = remember {
        mutableStateOf(false)
    }
    val checked2 = remember {
        mutableStateOf(false)
    }
    val checked3 = remember {
        mutableStateOf(false)
    }
    val checked4 = remember {
        mutableStateOf(false)
    }
    val checked5 = remember {
        mutableStateOf(false)
    }
    var checked6 by remember { mutableStateOf(false) }
    
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = checked1.value, onCheckedChange = { checked1.value = it })
            Text(text = "체크박스1")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = checked2.value, onCheckedChange = { checked2.value = it })
            Text(text = "체크박스2")
        }

        // @Composable () -> Unit
        CheckBoxWithText(checked = checked3, title = "체크박스3") {
            Text(text = "Slot 추가")
            // RowScope 범위 내에 없기 때문에 Alignment.CenterVertically시 에러남
            //Text(text = "Slot 추가", modifier = Modifier.align(Alignment.CenterVertically))
        }

        // @Composable RowScope.() -> Unit
        // 수신자를 RowScope로 세팅하면 람다 내에서 RowScope에 있는 것처럼 사용할 수 있음
        CheckBoxWithText2(checked = checked4, title = "체크박스4") {
            Text(text = "RowScope", modifier = Modifier.align(Alignment.CenterVertically))
        }

        // 상태 변경을 인자로 받기
        CheckBoxWithText3(checked = checked5.value, onCheckChanged = { checked5.value = !checked5.value }, title = "체크박스5" ) {
            Text(text = "onCheckboxChanged 전달", modifier = Modifier.align(Alignment.CenterVertically))
        }

        // 위임 프로퍼티를 사용하면 .value 없이 사용 가능하다
        CheckBoxWithText3(checked = checked6, onCheckChanged = { checked6 = !checked6 }, title = "체크박스5" ) {
            Text(text = "위임 프로퍼티 사용", modifier = Modifier.align(Alignment.CenterVertically))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SlotApiTheme {
        Greeting()
    }
}