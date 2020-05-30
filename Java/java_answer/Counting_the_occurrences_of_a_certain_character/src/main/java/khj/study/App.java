package khj.study;

/**
 * 특정 문자 발생 횟수
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( countOccurrencesOfACertainCharacter("Hello World!", 'o') );
    }

    public static int countOccurrencesOfACertainCharacter(String str, char ch) {
        System.out.println(str.length());
        System.out.println(str.replace(String.valueOf(ch), "").length());
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }

    public static int countOccurrencesOfACertainCharacter2(String str, String ch) {
        if (ch.codePointCount(0, ch.length()) > 1) {
            // there is more than 1 Unicode character in the given String
            // 주어진 문자열에 둘 이상의 유니 코드 문자가 있습니다
            return -1;
        }

        int result = str.length() - str.replace(ch, "").length();

        // if ch.length() return 2 then this is a Unicode surrogate pair
        // ch.length ()가 2를 반환하면 이것은 유니 코드 대리 쌍입니다.
        return ch.length() == 2 ? result / 2 : result;
    }

    public static int countOccurrencesOfACertainCharacter3(String str, char ch) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }

        return count;
    }

    public static long countOccurrencesOfACertainCharacter4(
            String str, char ch) {

        return str.chars()
                .filter(c -> c == ch)
                .count();
    }
}
