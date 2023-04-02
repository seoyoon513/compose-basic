## Image 연습

### 정적 이미지 추가
* ```Image()``` 사용
```kotlin
@Composable
fun ImageEx() {
    Column {
        // Step1 : Image 만들기
        Image(
            painter = painterResource(id = R.drawable.wall),
            contentDescription = "엔텔로프 캐넌"
        )

        // Step2 : ImageVector에 Incons.Filled.Settings를 설정
        Image(
            imageVector = Icons.Filled.Settings,
            contentDescription = "세팅"
        )
    }
}
```
### 동적 네트워크 이미지 추가
* Coil 라이브러리 사용
```kotlin
@Composable
fun CoilEx() {
    Column {
        // Step1 : rememberImagePainter를 이용하여 Image의 painter 설정
        // deprecated 됐지만 Compose 한국어 문서에서는 추천
        val painter =
            rememberImagePainter(data = "https://user-images.githubusercontent.com/110798031/229339695-86b240e9-039f-47b8-8ae9-05f514de7311.png")

        Image(
            painter = painter,
            contentDescription = "벌새"
        )

        // Step2 : AsyncImage 이용하여 image 띄우기
        // 공식 라이브러리에서 추천하는 방법
        AsyncImage(
            model = "https://user-images.githubusercontent.com/110798031/229339695-86b240e9-039f-47b8-8ae9-05f514de7311.png",
            contentDescription = "벌새"
        )
    }
}
```
![image](https://user-images.githubusercontent.com/110798031/229339788-10f97134-81ca-4ef9-b1c7-de26be92f79a.png)

### Coil 라이브러리
: 안드로이드 앱에서 이미지 로딩을 담당하는 오픈소스 라이브러리

**Coil 2.3.0 버전 사용 시 맞춰야 되는 것들**
```kotlin
    // Coil
    implementation "io.coil-kt:coil:2.3.0"
    implementation "io.coil-kt:coil-compose:2.3.0"
```
*  Koltin version 1.8.0 및 kotlinCompilerExtensionVersion 1.4.0
[Compose와 Kotlin 호환성 공식문서](https://developer.android.com/jetpack/androidx/releases/compose-kotlin?hl=ko)
```kolin
// build.gradle(project)
plugins {
    id 'com.android.application' version '7.3.1' apply false
    id 'com.android.library' version '7.3.1' apply false
    id 'org.jetbrains.kotlin.android' version '1.8.0' apply false
}

//build.gradle(app)
composeOptions {
    kotlinCompilerExtensionVersion '1.4.0'
}
````