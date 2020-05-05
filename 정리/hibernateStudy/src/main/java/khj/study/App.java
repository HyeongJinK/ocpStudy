package khj.study;

public class App
{
    public static void main( String[] args )
    {
        MainController mainController = MainControllerImpl.getInstance();

        mainController.start();
        mainController.finish();
    }
}
