## Row 연습
![정렬,배치](https://user-images.githubusercontent.com/110798031/229331138-b7b977a3-4faa-4141-ae3d-b34d517984f7.png)
- 수평 배치인 row의 Alignment(정렬)은 수직이며 Arrangement(배치)는 수평이다

### horizontalArrangement(수평 배치)
![image](https://user-images.githubusercontent.com/110798031/229331170-1f631b8b-2033-4e7d-9056-d87fd24d2a6a.png)
* ```Arrangement.SpaceBetween``` : 첫 번째 요소는 시작점에, 마지막 요소는 끝점에 배치한 채 빈 공간을 균등하게 나눈다
* ```Arrangement.SpaceAround``` : 컴포넌트의 간격이 s로 동일하고 양쪽 끝과 컴포넌트 사이의 빈 공간은 s/2이다
* ```Arrangement.SpaceEvenly``` : 컴포넌트의 간격이 s로 동일하고 양쪽 끝과 컴포넌트 사이의 빈 공간도 s로 동일하다
* SpaceAround와 SpaceEvenly를 보면 양쪽 끝 여백이 다르다는 것을 알 수 있다
  ![image](https://user-images.githubusercontent.com/110798031/229330557-e1205c13-8291-47bc-936a-2b9cb30abbb4.png)

### 자식 요소에 Modifier.weight(비중) 설정
- 자식 컴포넌트에 weight를 지정하여 row에서 차지하는 비율을 설정할 수 있다
```kotlin
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
```
![image](https://user-images.githubusercontent.com/110798031/229330878-ca8f8302-0927-439b-9053-f4584ec11e65.png)