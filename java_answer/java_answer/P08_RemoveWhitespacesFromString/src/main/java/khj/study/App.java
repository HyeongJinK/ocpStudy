package khj.study;

import java.util.concurrent.TimeUnit;

/**
 * 문자열에서 공백 제거
 *
 */
public class App 
{
    private static final String TEXT = "      My high\n\n school,        the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. \r"
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, \t"
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science.           ";

    public static void main(String[] args) {

        System.out.println("Input text: \n" + TEXT + "\n");

        System.out.println("replaceAll() solution:");
        long startTime = System.nanoTime();

        String result = removeWhitespaces(TEXT);

        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("String without blanks is: \n" + result);
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }

    public static String removeWhitespaces(String str) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return "";
        }

        return str.replaceAll("\\s", "");   //\s 로 보이지 않는 모든 공백 지정(\t, \n, \r)
    }
}
