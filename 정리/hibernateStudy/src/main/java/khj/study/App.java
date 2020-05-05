package khj.study;

public class App
{
    public static void main( String[] args )
    {
        MainService mainService = MainServiceImpl.getInstance();

        mainService.start();
        mainService.finish();
    }
}
