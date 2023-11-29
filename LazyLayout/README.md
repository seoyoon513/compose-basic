## LazyLayout 연습
### Lazy?
* 기존 View 시스템에서 RecyclerView와 유사함
* 화면에 표시될 때 스크롱 가능한 아이템 목록을 렌더링 (필요할 때만 보여주는 역할)
* LazyColum, LazyRow, LazyHorizontalGrid, LazyVerticalGrid가 여기에 속함

### header, footer
* header, footer의 경우 item블록으로 넣을 수 있다
```kotlin
LazyColumn(
    horizontalAlignment = Alignment.CenterHorizontally
) {
    // header와 footer를 item 블록으로 넣을 수 있음
    item {
        Text(text = ">>>>여행 정보 시작<<<<")
    }
    items(itemList) { item ->
        Item(itemData = item)
    }
}
```

### LazyColumn, LazyRow의 item 간격 설정
* Item 컴포저블 함수 자체에 padding값으로 간격 설정
* modifier의 padding속성으로 간격 설정
* contentPadding과 Arrangement.spaceBy 속성으로 간격 설정

### 스크롤 동작 제어
* 스크롤 동작을 제어하기 위해서는 스크롤 상태 관찰이 필요함
* 스크롤의 위치와 List 정보를 포함하는 객체 사용 `rememberLazyListState`
* 아래는 첫 번째 아이템 이후부터 up버튼을 노출하는 기능을 구현한 것이다

```kotlin
fun LazyColumnEx(itemList: List<ItemData>) {
  val listState = rememberLazyListState() // 스크롤 위치와 List 정보를 포함하는 객체
  val showButton by remember {
    derivedStateOf {
      listState.firstVisibleItemIndex > 0
    }
  }
}
```
* `derivedStateOf`로 감싼 경우, 블록 내의 조건이 충족될 때만 상태가 변경되고 Recomposition 된다
* 즉 불필요한 Recomposition를 하지 않아서 더욱 효율적이ㅎ 

### LazyGrid의 item 노출 개수 및 간격 설정
* `verticalArrangement`, `horizontalArrangement`속성에서 Arrangement.spaceBy값으로 간격 설정
* `rows` 혹은 `columns` 속성에서 cell 옵션 설정 가능
  * `rows = GridCells.Fixed(2)`를 사용하면 2로 고정된 Row를 구현할 수 있다
  * `rows = GridCells.Adaptive(100.dp)`을 사용하면 각 열의 최소 너비가 100dp고 화면 크기에 따라 동적으로 열의 개수를 조절한다
    <img width="535" alt="image" src="https://github.com/seoyoon513/compose-basic/assets/110798031/f0990895-3138-4fdc-ba25-5cea42e0b95f">
