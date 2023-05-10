// 최상위 영역
// java : int num = 1;
// 코틀린 : val(or var) 변수명 : 타입 = 값;
// 깃 사용시 주의사항.
// 1. 학원, 2. 집 , 3. 깃 원격지
// 항상 어디가 최신인지 알아야함.
// 예 ) 1. 학원 작업 후 저장. -> 3. 깃 원격지 저장.
// 예) 2. 집 : 같은 데이터가 아님. , 무엇을 먼저 해야하나요?
// pull 먼저하고 작업.
val num : Int = 1;
// 우리가 왜 IDE 를 사용하나요?
// 편의성. 기본적인 문법 체크를 해줍니다.
// 문법에 다 외울려고 안했으면 합니다.
// 최소한 기본 문법 정도만 알고 , 진행하자.
// 통계적으로 접근해라. -> 일단, 많이 자주 사용하는 것 부터. 시작.
// 최상위 영역에서는 선언만 하면 오류가 난다.
// 일단 ide 문법 체크를 최대한 이용하자.
//val num2 : String;

class Test {
}


class User3(name:String) { // 선언부
    // 본문
    // 주생성자 생략 -> 디폴트 생성자를 만들어줌.
    // 보조 생성자를 이용

    // 문제점 -> 주 생성자와 , 보조 생성자가 같이 있을 경우
    // 해결책은 -> 보조 생성자에서, 주 생성자로 연결하는 부분이 필요.
    // this
    // 결론, 보조 생성자를 이용하면 되지만, 주 생성자를 이용해라.
    // 작업 할 때에도, 주 생성자에서 작업을 더 많이 하는 편.
      constructor(name: String, count: Int) : this(name) {

    }

}

class User2(val name: String, count:Int) {
    // 주생성자의 지역변수 name
    //주생성자는 class 이름 옆에 선언이 되고,
    // constructor 를 생략을 많이함.

    // 클래스의 멤버 변수 name
    //var name="lsy";
    init {
        // init 함수 안에서는 주 생성자의 매개변수를 사용가능.
        // 하지만, class 멤버 변수로는 사용이 불가능.
        println("init 호출. 주생성자 매개변수 사용: $name")
    }

    fun someFun() {
        println("init 호출. 주생성자 매개변수 사용: $name")
    }

}

class User{ // 주생성자가 생략이되었고, 보조 생성자를 사용.
    var name = "lsy"
    // 생성자 모양이, 자바에서는 클래스명으로 똑같지만,
    // 코틀린은 생성자 키워드가 따로 존재함.
    // 보조 생성자
    constructor(name : String){
        this.name = name
    }
    fun someFun() {
        println("someFun() 의 name: $name")
    }
}

// 코틀린에서는 기본적으로 상속이 안됩니다.
// 그래서, 필요한 키워드가 : open
// 부모꺼를 사용 할려면, 반드시 초기화를 해야 사용가능합니다.
// super() 주생성자 호출 해야합니다.
open class Super {
    open var superData = 10
    // 접근 지정자 확인, protected 만 확인
    // 결론, 자식 클래스에서만, 부모 클래스 멤버에 접근 가능 여부 확인.
    // 즉, main 함수에서는 접근 불가.
    protected var protectedData = 20
   open fun superFun() {
        println("superFun 호출됨.")
    }
}

class Sub : Super() {
    // 부모의 멤버를 다시 재정의해서 사용할려고 하는데. 안됨.
    // 이유? 키워드, open , override 없어서.
    override var superData = 20

   override fun superFun() {
       //자식 클래스 접근 가능.
       protectedData++
        println("자식의 재정의 superFun 호출됨.")
    }

}
// 비 data 클래스
class NonDataClass(val name:String, val pw : String){

}
// data 클래스 -> 실제 값을 비교 해주는 변수는 주 생성자의 변수만 해줌.
data class DataClass(val name:String, val pw : String,val email:String){
//    lateinit var email:String
//    constructor(name: String,pw: String,email:String):this(name,pw){
//        this.email = email
//    }
}

open class Super2 {
    open var data = 10
    open fun some(){
        println("i am Super2: $data")
    }
}

val obj = object : Super2(){ // 타입을 지정을 안하면 Any 기본값.
    // 이렇게 사용 못하니, 반드시 타입을 지정 해야함.
    override var data = 20
    override fun some() {
        println("i am Super2 재사용한 값 : $data")
    }
}

class companionClassTest {
    // 자바의 static 키워드와 동일한 기능.
    // 멤버에 접근시, 클래스명에 점을 찍고 접근 함.
    companion object {
        var data = 10
        fun some() {
            println("data 의 값 : $data")
        }
    }
}

// 고차함수 사용예제,
// 고차함수 : 매개변수 또는 결과 값 자리에 함수가 들어가는 형태
fun testH(arg:(Int)->Boolean):()->String {
    val result = if(arg(10)){
        "valid"
    } else {
        "invalid"
    }
    return {"testH result 확인 : $result"}
}



fun main() {
    // ? null 허용 연산자 및 ,
    // ?. null 허용 변수 호출: 접근시 반드시 ?. 접근.
    // ?: 엘비스 연산자 : null 이 아니면, 아닌 값이 호출되고,
    // null 이면  , 지정한 기본값이 할당.
    val data20:String? = "lsy"
    println("data20 의 길이 : ${data20?.length ?: 0}")


    //고차함수 사용예제
    val result16 = testH({no -> no > 0})
    println(result16())

    val some2 = {no1:Int,no2:Int -> println("출력")
    no1 *no2
    }
    println("익명함수 출력 확인 some2(1,2) : ${some2(1,2)}")

    // 매개변수가 1하나인 람다식(익명함수), it로 대체 하기.
    // 자동으로 컴파일러가 , 자바 문법 -> 코틀린 문법으로 대체할 때,
    // 자동 변환시, 매개변수가 1개인 경우 it 로 바로 대체함.
    // request, 응답 객체 response 응답 객체 하나만 가리킬 때,
    // 이런 경우에도 it을 많이 사용함.
    val result14 : (Int)->Unit = { println(it)  }
    val y= result14(100)

    // 함수 타입. 변수에서 데이터 타입이 있듯이,
    // 함수 타입있음. 익명 클래스 만들 때, object
    // 클래스 선언부 뒤에 생략(Any)
    // 함수 도 결괏값의 타입을 생략한다면 -> Unit(void)
    // 익명 함수이지만, 이것의 타입을 명시.



    // 일반 함수
    fun some(no1:Int, no2:Int):Int {
        return no1 + no2
    }

    // 람다식 , 익명 함수 : 중괄호 안에 , 왼쪽: 매개변수,
    //오른쪽 : 수행할 문장
    // 매개변수 없다면, 왼쪽 부분과 화살표 모두 생략가능.
    val result13 = {no1:Int,no2:Int -> no1 + no2 }
    val x= result13(1,2)
    println("x의 값 : $x")




    //companion 클래스 사용 예제
    companionClassTest.data
    companionClassTest.some()

    //object 익명 클래스 사용 예제
    obj.data = 20
    obj.some()

    //data 클래스 실제 값 비교
    val data13 = DataClass("lsy","1234","email1")
    val data14 = DataClass("lsy","1234","email2")
    println("data13 의 주소값 : $data13")
    println("data14 의 주소값 : $data14")
    println("equals 이용한 값비교 : ${data13.equals(data14)}")

    // 실제 값이 아닌, 메모리 주소값 비교 부분 확인.
    val none1 = NonDataClass("lsy","1234")
    val none2 = NonDataClass("lsy","1234")
    println("none1 의 주소값 : $none1")
    println("none2 의 주소값 : $none2")
    println("equals 이용한 값비교 : ${none1.equals(none2)}")

    val obj = Sub()
    println("obj.superData의 값: "+obj.superData)
    obj.superFun()
    // 접근 불가.
    //obj.protectedData

    val user2 = User2("lsy",10)
    println("user2사용해보기 "+user2)

    //객체 생성, 인스턴스 생성.
    //자바 : User user = new User("lsy");
    val user = User("이상용")
    println("user의 name : "+user.name)
    user.someFun()

    var data12 = arrayOf<Int>(1,2,3)
    for((index,value ) in data12.withIndex()) {
        print("인덱스의 값: ")
        print(index)
        print("value의  값: ")
        print(value)
        if(index !== data12.size-1) print(",")
    }
    println()

    //반복문 활용해보기
    fun sum10 ():Int {
        val result = 0
        // in 1..10, in 1 until 10, in 1..10 step 2
        // in 10 downTo 1
        for (i in 10 downTo 1 ) {
            val sum = 0
            val result = sum + i
            println("반복문의 result의 값은 : $result")
        }
        return  result
    }
    sum10()



    var data11 = arrayOf<Int>(1,2,3)
    for(i in data11.indices) {
        print(data11[i])
        if(i !== data11.size-1) print(",")
    }
    println()

    var data10 = 5
    val result10 =  when {
        // is 해당 타입이 맞는지 확인.
        data10 < 10 -> "data10 < 10"
        else -> {
            "data10 의 값은 ??"
        }
    }
    println("data10 조건으로 result10 출력하기 : $result10")

    var data9 : Any = 5
    when(data9) {
        // is 해당 타입이 맞는지 확인.
        is String -> println("data9 의 값은 문자열: $data9")
        10 -> println("data9 의 값은 10")
        in 1..10 -> println("data9 의 값은 숫자 : $data9")
        "abc" -> println("data9 의 값은 abc")
        else -> {
            println("data9 의 값은 ??")
        }
    }

    var data8 = "abcd"
    when(data8) {
        "10" -> println("data8 의 값은 10")
        "abc" -> println("data8 의 값은 abc")
        else -> {
            println("data8 의 값은 ??")
        }
    }

    var data7 = 10
    when(data7) {
        10 -> println("data7 의 값은 10")
        20 -> println("data7 의 값은 20")
        else -> {
            println("data7 의 값은 ??")
        }
    }

    var data5 = 10;
    var data6 = if(data5>0) {
        println("표현식 확인.")
        30
    }else {

    }
    println("data6 : $data6")


    var map = mapOf<String,String>(Pair("one","hello"),"two" to "2")
    println("""
        map size : ${map.size}
        map data  : ${map.get("one")}, ${map.get("two")}
    """.trimIndent())

    // 가변리스트 확인.
    var mL = mutableListOf<Int>(1,2,3)
    mL.add(3,100)
    println("""
        mL size : ${mL.size}
        mL data 인덱스 3 : ${mL[3]}
    """.trimIndent())

    var list = listOf<Int>(1,2,3)
    // 불변 리스트 변경 불가.
    //list[0] = 100
    println("""
        list size : ${list.size}
        list data : ${list[0]}, ${list.get(1)}
    """.trimIndent())

    val data4 = intArrayOf(1,2,3)
    val data3 = arrayOf<Int>(1,2,3)

    val data2 : IntArray = IntArray(3,{0})
    data2[0] = 100
    println("data2의 값 조회 : ${data2[0]}")

    //배열 -> 자바(코틀린) : 동일한 데이터 타입의 값들을 할당함.
    // 비교 vs 자바스크립트 :여러 가지의 데이터 타입의 값들을 할당함.
    //Array(배열의갯수, 초깃값 )
    // 람다식은 문법이 : { 매개변수 -> 실행될 문장 }
    // 람다식에서 매개변수가 1개면 화살표, 매개변수를 생략
    // : {실행될 문장.  }
    val data1 :Array<Int> = Array(3,{0})
    println("data1의 값 조회 : ${data1[0]}")

    // 함수의 매개변수에서는 var, val 키워드 사용하면 안됨.
    // 자동으로 val 가 들어가 있다.
    fun sum3(no:Int, no2:Int) { // : Unit 생략 , 자바: void
        val result = no + no2
        println("no + no2 = $result")
    }

    // 함수의 결괏값의 타입을  Nothing
    fun some1():Nothing? { // ? null 허용이 가능한 연산자.
        return null
    }

    val num3 : Any = "이상용" // Any , Object 와 비슷.
    fun sum2(no:Int,no2:Int) { // : Unit 생략 , 자바: void
        val result = no + no2
        println("no + no2 = $result")
    }
    sum2(10,20)

    fun sum(no:Int):Int {
        // 타입이 추론이 되면, 생략가능.
        var sum = 0
        for (i in 1..no ){
            sum += i
        }
        return sum
    }
    val result = sum(10)
    println("result : $result")

    println("hi android")
    println("num 의 값 : $num")
}