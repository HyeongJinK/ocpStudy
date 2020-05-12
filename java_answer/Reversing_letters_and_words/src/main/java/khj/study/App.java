package khj.study;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 단어 반전
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( reverseWords("Hello World!"));
        System.out.println( reverseWords2("Hello World!"));
        System.out.println( reverse("Hello World!"));
    }

    private static final String WHITESPACE = " ";

    public static String reverseWords(String str) {
        String[] words = str.split(WHITESPACE);     //공백으로 단어 구
        StringBuilder reversedString = new StringBuilder();

        for (String word: words) {
            StringBuilder reverseWord = new StringBuilder();

            for (int i = word.length() - 1; i >= 0; i--) {  // 역순으로 가져와서 단어를 뒤집는다.
                reverseWord.append(word.charAt(i));
            }

            reversedString.append(reverseWord).append(WHITESPACE);
        }

        return reversedString.toString();
    }

    private static final Pattern PATTERN = Pattern.compile(" +");


    public static String reverseWords2(String str) {
        return PATTERN.splitAsStream(str)
                .map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(" "));
    }

    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
