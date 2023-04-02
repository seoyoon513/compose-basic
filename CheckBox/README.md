## ChekBox 연습
![image](https://user-images.githubusercontent.com/110798031/229343871-e266c1bd-d1f4-4706-9551-e090af90f6b3.png)
* CheckBox을 선택할 수 있게 하려면 remember를 사용하여 상태관리를 해야한다

### Remember 함수
* Composable 함수에서 값을 보존하고 상태를 유지할 때 사용하는 함수
* remember를 사용하면 앱이 다시 그려질 때마다 값을 계산하지 않고 이전 값을 재사용할 수 있음
* remeber의 값을 업데이트하는 로직은 **이전 값과 새로운 값을 비교하고, 변경된 경우에만 새로운 값을 반환하는 것**
* 그렇기 때문에 값을 변경할 수 있는 **mutableState()** 타입의 값을 저장한다

### MutableState()
```kotlin
interface MutableState<T> : State<T> {
    override var value: T
    operator fun component1(): T
    operator fun component2(): (T) -> Unit
}
```
* State의 하위 인터페이스이며 Compose에서 상태를 정의하는 인터페이스
* ```value``` : 읽기/쓰기가 가능한 프로퍼티
* ```component1()``` : 읽기만 가능한 함수 (value와 같은 값 반환)
* ```component2()``` : 쓰기만 가능한 함수

```kotlin
@Stable
interface State<out T> {
    val value: T
}
```
* State는 읽기 전용인 value 프로퍼티를 가짐 (불변)

### remember 초기화
**1. 변수에 remember 할당**
```kotlin
var checked = remember { mutableStateOf(false) }
```
* mutableState()의 value 프로퍼티에 접근하여 값을 읽고 업데이트 해야한다 (`checked.value`)

**2. 위임(by) 사용**
```kotlin
var checked by remember { mutableStateOf(false) }
```
* checked를 value 프로퍼티처럼 사용 가능하다
* value 프로퍼티에 접근하지 않고도 값을 읽고 업데이트 할 수 있다 (`checked`)

**3. 구조분해 사용**
: 객체를 분해하여 여러 개의 변수로 나누어 대입하는 것
```kotlin
val (checked, setChecked) = remember { mutableStateOf(false) }
```
* mutableState에서 component1은 상태의 값을 반환하고, component2는 상태를 업데이트할 수 있는 함수를 반환한다
* 이것은 value와 setValue를 사용하지 않고도, 객체 분해(destructuring)를 통해 상태를 쉽게 읽고 업데이트할 수 있도록 한다
* 위와 같이 객체를 분해(destructuring)을 할 경우 `checked`로 값을 읽고 `setChecked`로 값을 업데이트 할 수 있다