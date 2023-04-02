## BoxWithConstraints 연습
* BoxWithConstraints에는 5가지 종류의 변수에 접근할 수 있다
```kotlin
@Stable
interface BoxWithConstraintsScope : BoxScope {
    /**
     * The constraints given by the parent layout in pixels.
     *
     * Use [minWidth], [maxWidth], [minHeight] or [maxHeight] if you need value in [Dp].
     */
    val constraints: Constraints
    val minWidth: Dp
    val maxWidth: Dp
    val minHeight: Dp
    val maxHeight: Dp
}
```
* 기존 Box와의 차이점은 BoxWithConstraintsScope를 제공하여 Box의 최소/최대 제약을 지정하고
* 자식 요소들에게 추가로 최소/최대 제약 조건을 지정할 수 있다

### 예시
![image](https://user-images.githubusercontent.com/110798031/229336700-cb4d0339-e88e-4749-8bfb-8ca8291a7e63.png)
```kotlin
@Composable
fun Outer() {
    Column(
        // Step4 : 부모 layout에 제약 추가
        modifier = Modifier
            .width(300.dp)
            .background(Color.Yellow)
    ) {
        // Step2 : Inner의 인지로 Modifier.widthIn(min = 100.dp) 설정
        Inner(
            modifier = Modifier
                .widthIn(min = 100.dp, max = 350.dp) // max를 392이상으로 쓸 수 없다
                .heightIn(min = 100.dp, max = 140.dp)
                .background(Color.Magenta)
        )

        Inner(
            modifier = Modifier
                .width(200.dp) // max를 392이상으로 쓸 수 없다
                .height(200.dp)
                .background(Color.Cyan)
        )
    }
}

// Step1 : Inner 인자로 modifier 전달. 기본값을 Modifier로 지정
@Composable
fun Inner(modifier: Modifier = Modifier) {
    BoxWithConstraints(modifier) {
        // Step3 : maxHeight가 150dp 가 넘을 때만 추가로 텍스트 출력
        if (maxHeight > 150.dp) {
            Text(text = "여기 꽤 길군요!", modifier = Modifier.align(Alignment.BottomCenter))
        }

        Text(
            text = "maxW:$maxWidth maxH:$maxHeight minW:$minWidth minH:$minHeight",
            modifier = Modifier
                .fillMaxSize()
                // Step5 : color 제약조건 추가
                //.background(if (maxHeight < 150.dp)Color.Red else Color.Cyan)
        )
    }
}
```
* 부모 layout인 Column의 width를 300dp로 제약을 주었을 때 자식의 maxWidth값을 350dp로 지정해주어도 300dp의 결과가 나오는 것을 알 수 있다
* 또한 크기 제약 조건에 따라 Text를 추가로 그리거나 background color 등을 변경할 수 있다
* 이러한 특징은 휴대폰 상에 보여지는 Box크기에 따라 다른 화면을 내보낼 수 있도록 한다
* 즉 다양한 화면 크기에 맞는 레이아웃을 작성할 수 있다 (Galaxy Flip과 Fold 시리즈의 가변적 화면 사이즈 대응에 적합)
* 크기 설정을 안해줬을 때의 각 속성의 값은 다음과 같다
  ![image](https://user-images.githubusercontent.com/110798031/229333829-2ebcee56-951a-458d-9b85-5e5e38b24642.png)

