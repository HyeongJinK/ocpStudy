package khj.study._1th

fun main(args: Array<String>) {
    print("Hello World")
    print(max(1, 2))
    val a = 1;  // 변경 불가능한 참조
    var b = 2;  // 변경 가능한 참조
    // 문자열 템플릿
    val c = "aaa"
    print("dddd ${c}")

    
    val d = A("test", "test2")
    println(d.aaa)  // 프로퍼티의 이름을 사용하면 자동으로 게터를 사용한다.
}
/**
 * 함수선언
 * */
fun max (a: Int, b: Int): Int { // 함수이름, 파라미터목록, 리턴타입
    return if (a > b) a else b
}

fun max2 (a: Int, b: Int): Int = if (a > b) a else b

fun max3 (a: Int, b: Int) = if (a > b) a else b // 반환타입 생략 가능
/**
 * 프로퍼티
 * */
class A (
    val aaa: String,    //읽기 전용 프로퍼티, getter
    var bbb: String     //쓰기, getter, setter
)
/**
 * 커스텀 접근자
 * */

class Custom(var aaaa: Int) {
    private var bbbb: Int = 0
        get() {
            return bbbb;
        }
}