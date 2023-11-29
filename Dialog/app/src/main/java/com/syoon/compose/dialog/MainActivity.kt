package com.syoon.compose.dialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.syoon.compose.dialog.ui.theme.DialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DialogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //AlertDialogEx()
                    CustomDialogEx()
                }
            }
        }
    }
}

@Composable
fun AlertDialogEx() {
    var openDialog by remember {
        mutableStateOf(false)
    }
    var counter by remember {
        mutableStateOf(0)
    }

    Column {
        Button(onClick = { openDialog = true }) {
            Text(text = "Alert 다이얼로그 열기")
        }
        Text(text = "카운터 $counter")
    }

    if (openDialog) {
        AlertDialog(
            onDismissRequest = {
                // 다이얼로그가 띄워졌을 때 다이얼로그 영영 밖 클릭 시 동작
                openDialog = false
            },
            confirmButton = {
                // 오른쪽 버튼 영역
                Button(onClick = {
                    counter++
                    openDialog = false
                }) {
                    Text(text = "더하기")
                }
            },
            dismissButton = {
                // 왼쪽 버튼 영역
                Button(onClick = {
                    openDialog = false
                }) {
                    Text(text = "취소")
                }
            },
            title = { Text(text = "더하기") },
            text = { Text(text = "더하기 버튼을 누르면 카운터를 증가합니다.\n버튼을 눌러주세요") }
        )
    }
}

@Composable
fun CustomDialogEx() {
    var openDialog by remember {
        mutableStateOf(false)
    }
    var counter by remember {
        mutableStateOf(0)
    }

    Column {
        Button(onClick = { openDialog = true }) {
            Text(text = "커스텀 다이얼로그 열기")
        }
        Text(text = "카운터 $counter")
    }

    if (openDialog) {
        Dialog(
            onDismissRequest = { openDialog = false },
        ) {
            Surface {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(text = "버튼을 클릭해주세여.\n* +1을 누르면 값이 증가합니다.\n* -1을 누르면 값이 감소합니다")
                    Row {
                        Button(onClick = {
                            openDialog = false
                        }) {
                            Text(text = "취소")
                        }
                        Button(onClick = {
                            openDialog = false
                            counter ++
                        }) {
                            Text(text = "+1")
                        }
                        Button(onClick = {
                            openDialog = false
                            counter --
                        }) {
                            Text(text = "-1")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    DialogTheme {
        AlertDialogEx()
    }
}