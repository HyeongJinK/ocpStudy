package khj.study;

/**
 * 클래스 검사
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Pair pair = new Pair(1, 1);

        Class<?> clazz = pair.getClass();

        // khj.study.Pair
        System.out.println("Name: " + clazz.getName());

        // Pair
        System.out.println("Simple name: " + clazz.getSimpleName());

        // khj.study.Pair
        System.out.println("Canonical name: " + clazz.getCanonicalName());
    }


}
