## Scaffold 연습
### Scaffold?
- 기본적인 앱 레이아웃을 정의하는데 사용
- 상단바(AppBar), 하단 탐색 바(BottomAppBar), Drawer와 같은 요소를 포함하는, 기본적엔 레이아웃을 제공
```kotlin
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { /* Title content */ },
                actions = { /* Action content */ }
            )
        },
        content = {
            // Main content of the app
        }
    )
```
### Surface?
- 콘텐츠를 그릴 수 있는 영역을 나타내며, 콘텐츠를 강조하거나 데코레이션을 추가하는 경우에 사용
- 배경색, 모서리 모양 등 시각적인 속성(데코레이션)을 정의하는데 사용
- 콘텐츠를 Surface로 감싸서 배경색과 그림자를 설정할 수 있음

### Scaffold의 PaddingValue?
<img width="651" alt="image" src="https://github.com/seoyoon513/compose-basic/assets/110798031/f6b8de48-febd-4c4d-8459-613ab5a83360">

- content에 PaddingValue 인자를 받는 [이유](https://developer.android.com/jetpack/compose/layouts/material?hl=ko#screen-content)는?
- Scaffold에는 상단바(topBar)와 하단바(bottomBar) 요소가 있는데, 이들이 존재할 경우 이를 offset하기 때문
- 즉 bottomBar를 설정하면 bottomPadding을 bottomBar의 컨텐츠 높이로 설정한다
```kotlin
Scaffold(/* ... */) { contentPadding ->
    // Screen content
    Box(modifier = Modifier.padding(contentPadding)) { /* ... */ }
}
```
### 비교 테스트
- 최상단 컴포저블 함수 Scaffold
<img src="https://github.com/seoyoon513/compose-basic/assets/110798031/9380a647-ea56-42d4-9ba5-f2ef0c8bcb4a" width="300" >
- 최상단 컴포저블 함수 Column
<img src="https://github.com/seoyoon513/compose-basic/assets/110798031/1f2642f3-df06-4f76-a567-45018453ba06" width="300" >
