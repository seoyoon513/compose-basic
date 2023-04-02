## Column 연습

![image](https://user-images.githubusercontent.com/110798031/229332631-29d59913-9ae1-4ffd-8c4e-e20a7519e6c3.png)
* 수직 배치인 column의 Alignment(정렬)는 수평이다 (Alignment는 레이아웃 방향과 수직으로 진행)
* Arrangement(배치)는 수직이다 (Arrangement는 레이아웃 방향과 동일)

### Alignment 설정
![image](https://user-images.githubusercontent.com/110798031/229332848-c47e2415-ef69-456c-aaa6-31c49757bcdc.png)
* Alignment는 위에서 정의한 상수로 요소들의 위치를 조정하는 데 사용된다
- Column과 Row는 1차원 배치만 지원하고 (```1D Alignment.Vertical```s or ```1D Alignment.Horizontals```) Box는 2차원 배치를 지원한다 (```2D Alignments```)

### verticalArrangement(수직 배치)
![image](https://user-images.githubusercontent.com/110798031/229333071-d72dca0c-1127-41ed-a7be-1fb28c82cb1d.png)

### 배치 연습
```kotlin
Column(
    horizontalAlignment = Alignment.End,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier.size(100.dp)
) {
    Text(text = "첫 번째!", modifier = Modifier.align(Alignment.CenterHorizontally))
    Text(text = "두 번째!")
    Text(text = "세 번째!", modifier = Modifier.align(Alignment.Start))
}
```
![image](https://user-images.githubusercontent.com/110798031/229332437-00256b1a-8c95-4563-ad9a-ba20be6847da.png)
