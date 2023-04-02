## Modifier 연습

### "Modifier parameter should be the first optional parameter"
* IDE에서는 Modifier를 첫 번째 optional parameter로 설정하도록 권장한다
* 이유는 자주 사용되는 파라미터이기 때문에 가독성에 용이하고
* **선택적인 기본값이 있는 매개변수들은 호출자가 생략할 수 있기 때문이다**

```kotlin
@Composable
fun TextWithWarning1(
    name: String = "Default",
    modifier: Modifier,
    callback: () -> Unit,
) {
    Text(text = "TextWithWarning1! $name", modifier = modifier
        .background(Color.Yellow)
        .clickable { callback.invoke() })
}
```
* 위의 함수는 첫 번째 파라미터로 선택적 기본값인 name을 받는다
* 이 함수를 호출할 때 굳이 정의하지 않아도 되는 name parameter값의 초기화를 강제받게 된다
* 초기화를 강제 받지 않으려면 호출 시 매개변수의 이름을 명시해야한다

```kotlin
TextWithWarning1(Modifier) {} // error : name 매개변수 없이 정의 불가능
TextWithWarning1("",Modifier) {} // name의 초기화가 무조건 진행되어야 함
TextWithWarning1(modifier = Modifier) {} // name을 생략하고 싶으면 modifier(매개변수 이름) 명시
```                
- 하지만 매개변수의 이름을 모르는 경우에는 생략할 수 없기 때문에 일반적으로 기본값이 있는 매개변수는 나중에 위치하도록 하는 것이 좋다

### 버튼 background 색 속성 변경 사항
|M2|M3|
|---|---|
|```backgroundColor```|```containerColor```|
