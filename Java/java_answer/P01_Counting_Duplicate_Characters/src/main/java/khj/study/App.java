package khj.study;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 각각의 문자가 몇번씩 나오는 지 체크하기
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println(countDuplicateCharactersV1("Hello World!"));
        System.out.println(countDuplicateCharactersV2("Hello World!"));
    }

    public static Map<Character, Integer> countDuplicateCharactersV1(String str) {
        if (str == null || str.isBlank()) {
            /**
             * isBlank : java 11
             * 문자열이 비어 있거나 공백 코드 포인트만 포함하면 true를 그렇지 않으면 false를 반환합니다.
             * */
            return Collections.emptyMap();
        }

        Map<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            result.compute(ch, (key, value) -> (value == null) ? 1 : ++value);
        }

        return result;
    }

    public static Map<String, Integer> countDuplicateCharactersVCP1(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.emptyMap();
        }

        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            /*
            String ch = String.valueOf(Character.toChars(str.codePointAt(i)));
            if (i < str.length() - 1 && str.codePointCount(i, i + 2) == 1) {
                i++;
            }
            */

            // or, like this (this code produce the same result as the commented code above
            int cp = str.codePointAt(i);
            String ch = String.valueOf(Character.toChars(cp));
            if (Character.charCount(cp) == 2) { // 2 means a suroggate pair
                i++;
            }

            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        return result;
    }
    /**
     * 원래 문자열에서 String.chars ()메소드를 호출하십시오. IntStream을 반환합니다. 이 IntStream은 주어진 문자열에서 문자의 정수 표현을 포함합니다.
     * mapToObj() 메소드를 통해 IntStream을 문자 스트림으로 변환합니다 (정수 표현을 인간 친화적 문자 형식으로 변환).
     * 마지막으로 문자 (Collectors.groupingBy())를 그룹화 하고 계산합니다 (Collectors.counting()).
     * */
    public static Map<Character, Long> countDuplicateCharactersV2(String str) {
        Map<Character, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return result;
    }
}
