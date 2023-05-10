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

fun main() {

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