package khj.study;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 두 배열 비교
 *
 * 주어진 배열이 같고 동일한 순서로 동일한 요소를 포함하는 경우 0
 * 첫 번째 배열이 사 전적으로 두 번째 배열보다 작은 경우 0보다 작은 값
 * 첫 번째 배열이 사 전적으로 두 번째 배열보다 큰 경우 0보다 큰 값
 */
public class App 
{
    public static void main( String[] args )
    {
        int[] integers1 = {3, 4, 5, 6, 1, 5};
        int[] integers2 = {3, 4, 5, 6, 1, 5};
        int[] integers3 = {3, 4, 5, 6, 1, 3};

        int i12 = Arrays.compare(integers1, integers2); // 0
        int i13 = Arrays.compare(integers1, integers3); // 1
        int is13 = Arrays.compare(integers1, 3, 6, integers3, 3, 6); // 1

        System.out.println(i12);
        System.out.println(i13);
        System.out.println(is13);

        Melon[] melons1 = {new Melon("Horned", 1500), new Melon("Gac", 1000)};
        Melon[] melons2 = {new Melon("Horned", 1500), new Melon("Gac", 1000)};
        Melon[] melons3 = {new Melon("Hami", 1600), new Melon("Gac", 800)};

        int m12 = Arrays.compare(melons1, melons2); // 0
        int m13 = Arrays.compare(melons1, melons3); // -1
        int ms13 = Arrays.compare(melons1, 1, 2, melons3, 1, 2); // 1

        System.out.println(m12);
        System.out.println(m13);
        System.out.println(ms13);

        Comparator<Melon> byType = Comparator.comparing(Melon::getType);
        int mt13 = Arrays.compare(melons1, melons3, byType); // 14
        System.out.println(mt13);

        int mrt13 = Arrays.compare(melons1, 1, 2, melons3, 1, 2, byType); // 0
        System.out.println(mrt13);
    }
}
