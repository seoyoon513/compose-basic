## Surface 연습
![surface_practice](https://user-images.githubusercontent.com/110798031/229327554-aa68a2b6-7cd9-40ad-b0ee-60d760773fff.png)

Compose에서는 Surface는 다음과 같이 설명한다

![surface](https://user-images.githubusercontent.com/110798031/229327123-c3cf1dcf-2f79-4808-9bd7-22ec5896909e.png)
* contentColor가 지정되지 않은 경우, Surface는 배경색상을 기준으로 컨텐츠 색상을 **자동으로 결정한다**
* 이때 Surface의 배경색상이 Material Design에서 정의한 색상 팔레트(ColorScheme)의 색상 중 하나와 일치하면, 해당 색상의 컨텐츠 색상이 사용된다
* 예를들어 Surface의 배경색상이 ColorScheme.surface와 일치하는 경우, 해당 Surface 내부의 Text나 Icon 요소는 ColorScheme.onSurface 색상으로 그려진다
* 아래는 color 속성을 각각 ```colorScheme```에 있는 색상으로 바꿨을 때의 결과물이다

|surface|primary|secondary|error|
|---|---|---|---|
|![surface](https://user-images.githubusercontent.com/110798031/229326824-6b28f4b9-58fd-4afb-90e9-6e559b2a0309.png)|![primary](https://user-images.githubusercontent.com/110798031/229326860-0fd025b0-e34d-44a5-8f33-520c2936c564.png)|![secondary](https://user-images.githubusercontent.com/110798031/229326905-39ecb8d5-1cda-436e-a9b4-1ec23f006c60.png)|![error](https://user-images.githubusercontent.com/110798031/229326926-cae0a8c5-bf9d-47dc-b3d5-788ba9268df1.png)|






