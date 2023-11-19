## TextField 연습

```kotlin
var name = ""
var rememberName by remember { mutableStateOf("") }
Column(modifier = Modifier.padding(16.dp)) {
    // 1.일반 변수
    TextField(
        value = name,
        onValueChange = { input -> name = input},
    )
    // 2.remember 변수
    OutlinedTextField(
        value = rememberName,
        onValueChange = { input -> rememberName = input },
    )
}
```
* `value` : 현재 텍스트 필드에 표시되는 값, 사용자가 텍스트를 입력하면 자동으로 업데이트
* `onValueChange` : 사용자가 텍스트 입력할 때마다 호출되는 람다 함수

### 일반 변수 Name을 사용할 경우
- 사용자가 문자를 입력할 때마다 onValueChanged가 호출되면서 입력된 텍스트를 name변수에 할당함
- name변수는 변경되지만 상태관리 함수를 사용하지 않았기 때문에 Compose는 상태 변경을 감지하지 못함
- UI가 업데이트 되지 않음

### Remeber 함수를 사용할 경우
* 사용자가 문자를 입력할 때마다 onValueChanged가 호출되면서 입력된 텍스트를 RememberName변수에 할당함
* remember 함수를 통해 상태를 추척하고 변경 감지함 -> recomposition !!
* UI가 업데이트되며 변경된 값이 텍스트필드에 반영

### OutlineTextField
```kotlin
var rememberName by remember { mutableStateOf("") }
val isError = rememberName == "sy"
OutlinedTextField(
    value = rememberName,
    onValueChange = { input -> rememberName = input },
    isError = isError,
    placeholder= { Text(text = "hint", style = TextStyle(color = Color.Blue))},
    colors = TextFieldDefaults.outlinedTextFieldColors(
        unfocusedBorderColor = Color.Blue,
        focusedBorderColor = Color.Green,
        errorBorderColor = Color.Yellow,
    ),
    supportingText = {Text(text = if (isError) "그건 내 이름이에요" else "")}
)
```
* 테두리 색의 경우 `TextFieldDefaults.outlinedTextFieldColors`로 변경
* hint의 경우 `placeholder` 사용

