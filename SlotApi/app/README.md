## Slot API 연습
### Slot?
- 컴포저블 함수 내에 컴포저블 함수를 슬롯처럼 넣는 패턴
- Slot은 Column, Row, Scafford, TopAppBar .. 등이 있다

```kotlin
inline fun Column(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    content: @Composable ColumnScope.() -> Unit
) {
    val measurePolicy = columnMeasurePolicy(verticalArrangement, horizontalAlignment)
    Layout(
        content = { ColumnScopeInstance.content() },
        measurePolicy = measurePolicy,
        modifier = modifier
    )
}
```
- content 매개변수 `@Composable ColumnScope.() -> Unit`가 Slot 역할을 하게 해준다
- `@Composable` : Compose에서 UI를 빌드하는 함수이다
- `ColumnScope` : Column 내에서 특정한 레이아웃이나 구성을 추가할 수 있게 해주며 생략 가능하다
- 마지막 인자가 람다식이기 때문에 아래와 같이 쓸 수 있다 (후행 람다로 전달)
```kotlin
Column {
    // 컴포저블 함수 삽입
}
```

만약 ColumnScope 또는 RowScope로 수신자를 변경하지 않으면, align과 같은 특정 구성을 가질 수 없다
![image](https://github.com/seoyoon513/compose-basic/assets/110798031/75508bea-4dc6-4412-9741-1068659564f4)
