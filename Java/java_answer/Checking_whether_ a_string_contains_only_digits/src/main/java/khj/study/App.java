package khj.study;

/**
 * 숫자만 있는 가?
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( containsOnlyDigits("Hello World!") );
        System.out.println( containsOnlyDigits("123123123") );
        System.out.println( containsOnlyDigits("aksdjf234") );
        // 자바8 & 정규식보다 첫번째 방법이 더 빠르다
    }

    public static boolean containsOnlyDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean containsOnlyDigits2(String str) {
        return !str.chars()
                .anyMatch(n -> !Character.isDigit(n));
    }

    public static boolean containsOnlyDigits3(String str) {     // 정규표현식
        return str.matches("[0-9]+");
    }
}
