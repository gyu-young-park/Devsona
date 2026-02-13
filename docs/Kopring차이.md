# Java Spring vs Kotlin Spring의 차이

## 문법
kotlin은 생성자를 통해서 맴버 필드를 정의하고 할당할 수 있다. 이를 위해서 `var`, `val`을 쓰는데, 주로 `private`는 쓰지 않는다. 정리하면 다음과 같다.

1. var --java--> public getter, setter 
2. val --java--> public getter 
3. private --java--> private final

물론 대충 정리한 것이기 때문에 1대1 매칭은 아니다. 

그래서 생성자로 bean을 주입받을 때는 `private val field`로 쓴다. 이렇게 쓰면 자바에서 처럼 `private final`로 '생성자로 주입 한 번 받고, 더 이상 안바꾸고 외부에 노출도 안한다'와 같다.

## JPA
JPA 사용 시 Entity에는 다음의 조건이 있다.

1. Entity는 빈 생성자가 있어야 한다.
2. 각 field에 대한 getter, setter가 필요하다. 
3. Entity는 상속될 수 있어야 한다.

java에서는 보통 lombok을 통해서 이를 해결하지만, kotlin에서는 빈 생성자를 명시적으로 만들어주어야 하고, 각 field에 대한 getter, setter를 위해서 `var`로 명시한다. 또한, 기본적으로 kotlin은 클래스가 closed되어있기 때문에 open으로 바꾸어주어야 상속이 가능하다.

또한, kotlin에서는 `@Id`의 field가 `nullable`이어야 한다. 

```kotlin
@Entity
@Table(name = "member")
open class MemberEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var username: String,

    @Column
    var alias: String,

    @Column
    var email: String,

    @Column
    var age: Int,
): BaseEntity() {
    constructor() : this(null, "", "", "", -1)
}
```
이유는 `id`값은 jpa에서 자동으로 넣어주는 값인데, 초기 `MemberEntity` 생성 시에 값이 없기 때문에 임의의 값으로 채우면 DB에서 기존에 있는 entity인줄 알고 혼동하기 때문이다. 이는 자바에서도 `long` 말고 `Long`을 쓰도록 하는 이유와 같다. 

이를 위한 plugin이 있지만, plugin 사용 전에 이 이유를 알고 하도록 하자.

