package khj.study;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println(countDuplicateCharacters("Hello World!"));
        System.out.println(countDuplicateCharacters2("Hello World!"));
    }

    public static Map<Character, Integer> countDuplicateCharacters(String str) {
        Map<Character, Integer> result = new HashMap<>();

        for (int i = 0; i<str.length(); i++) {
            char ch = str.charAt(i);

            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        return result;
    }
    /**
     * 원래 문자열에서 String.chars ()메소드를 호출하십시오. IntStream을 반환합니다. 이 IntStream은 주어진 문자열에서 문자의 정수 표현을 포함합니다.
     * mapToObj() 메소드를 통해 IntStream을 문자 스트림으로 변환합니다 (정수 표현을 인간 친화적 문자 형식으로 변환).
     * 마지막으로 문자 (Collectors.groupingBy())를 그룹화 하고 계산합니다 (Collectors.counting()).
     * */
    public static Map<Character, Long> countDuplicateCharacters2(String str) {
        Map<Character, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return result;
    }
}
