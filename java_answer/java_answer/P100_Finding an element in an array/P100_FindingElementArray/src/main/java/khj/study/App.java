package khj.study;

import java.util.Arrays;

/**
 * 배열에서 요소 찾기
 */
public class App 
{
    public static void main( String[] args )
    {

        int[] numbers = {4, 5, 1, 3, 7, 4, 1};

        System.out.println(containsElement(numbers, 5));
        System.out.println(containsElement(numbers, 8));

        System.out.println(containsElement2(numbers, 5));
        System.out.println(containsElement2(numbers, 8));
    }

    public static boolean containsElement(int[] arr, int toContain) {
        for (int elem: arr) {
            if (elem == toContain) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsElement2(int[] arr, int toContain) {
        Arrays.sort(arr);
        int index = Arrays.binarySearch(arr, toContain);
        return (index >= 0);
    }

}
