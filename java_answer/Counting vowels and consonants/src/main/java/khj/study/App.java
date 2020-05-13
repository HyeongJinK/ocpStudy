package khj.study;

import java.util.concurrent.TimeUnit;

/**
 * 자음, 모음 카운팅
 *
 */
public class App
{
    private static final String TEXT = " ... Illinois Mathematics & Science Academy ... ";

    public static void main(String[] args) {

        System.out.println("Input text: \n" + TEXT + "\n");

        System.out.println("String.charAt() solution:");
        long startTimeV1 = System.nanoTime();

        Pair pairV1 = Strings.countVowelsAndConsonants(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("Vowels: " + pairV1.vowels);
        System.out.println("Consonants: " + pairV1.consonants);

        System.out.println();
        System.out.println("Java 8, functional-style solution1:");
        long startTimeV2 = System.nanoTime();

        Pair pairV2 = Strings.countVowelsAndConsonants2(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("Vowels: " + pairV2.vowels);
        System.out.println("Consonants: " + pairV2.consonants);

        System.out.println();
        System.out.println("Java 8, functional-style solution2:");
        long startTimeV3 = System.nanoTime();

        Pair pairV3 = Strings.countVowelsAndConsonants3(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("Vowels: " + pairV3.vowels);
        System.out.println("Consonants: " + pairV3.consonants);
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
