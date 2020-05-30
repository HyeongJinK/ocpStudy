package khj.study;

import java.io.File;

/**
 * 패키지 검사
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Class clazz = null;
        try {
            clazz = Class.forName("java.lang.Integer");
            Package packageOfClazz = clazz.getPackage();

            // java.lang
            String packageNameOfClazz = packageOfClazz.getName();
            System.out.println(packageNameOfClazz);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        File file = new File(".");
        Package packageOfFile = file.getClass().getPackage();

        // java.io
        String packageNameOfFile = packageOfFile.getName();
        System.out.println(packageNameOfFile);
    }
}
