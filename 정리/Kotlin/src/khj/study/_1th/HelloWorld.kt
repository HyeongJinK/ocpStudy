package khj.study._1th

fun main(args: Array<String>) {
    print("Hello World")
    print(max(1, 2))
    val a = 1;  // 변경 불가능한 참조
    var b = 2;  // 변경 가능한 참조
    // 문자열 템플릿
    val c = "aaa"
    print("dddd ${c}")
}

fun max (a: Int, b: Int): Int { // 함수이름, 파라미터목록, 리턴타입
    return if (a > b) a else b
}

fun max2 (a: Int, b: Int): Int = if (a > b) a else b

fun max3 (a: Int, b: Int) = if (a > b) a else b // 반환타입 생략 가능

class A (
    val aaa: String,    //읽기 전용 프로퍼티, getter
    var bbb: String     //쓰기, getter, setter
)