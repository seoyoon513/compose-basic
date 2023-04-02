## Box 연습
![image](https://user-images.githubusercontent.com/110798031/229328990-6ea4e790-d9e2-4025-ad5d-935d27b89a0d.png)


* Box는 자식 요소를 겹쳐서 배치할 수 있으며, 이를 통해 UI 요소들을 쌓아 올리는 특징이 있다
* ```Modifier.align``` 을 사용하여 자식 요소를 Box 내에 배치할 수 있다

### Box의 Size
* Box의 Size를 지정하지 않으면 자식 요소에 맞게 크기를 지정한다
* 아래의 예시를 보자

![image](https://user-images.githubusercontent.com/110798031/229328902-cfbc54d0-7a8a-4c80-9a2d-f28a4cec3116.png)

```kotlin
 Box { // 1. 부모는 70 사이즈로 지정된 두 번째 Box의 크기로 설정됨
    Box(modifier = Modifier
        .matchParentSize() // 2. 부모 사이즈에 맞추면 70.dp가 되면서 두 번째 Box에 가려짐
        .background(Color.Cyan)
        .align(Alignment.CenterStart))
    Box(modifier = Modifier
        .size(70.dp)
        .background(Color.Yellow)
        .align(Alignment.BottomEnd))
}
```
![image](https://user-images.githubusercontent.com/110798031/229328934-f947526f-7968-443d-ba22-46f924bd1dce.png)

```kotlin
Box { // 1. 부모는 fillMaxSize()인 전체 사이즈로 설정됨
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan)
        .align(Alignment.CenterStart))
    Box(modifier = Modifier
        .size(70.dp)
        .background(Color.Yellow)
        .align(Alignment.BottomEnd))
}
```