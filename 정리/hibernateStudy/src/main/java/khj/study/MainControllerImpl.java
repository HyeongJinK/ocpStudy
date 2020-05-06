package khj.study;

import khj.study.configuration.EntityMangerConfiguration;
import khj.study.shop.controller.ShopController;
import khj.study.shop.controller.ShopControllerImpl;

public class MainControllerImpl implements MainController {
    private static MainControllerImpl mainService = new MainControllerImpl();

    private final ShopController shopController;

    public MainControllerImpl() {
        shopController = ShopControllerImpl.getInstance();
    }

    public static MainController getInstance() {
        return mainService;
    }

    @Override
    public void start() {
        shopController.shopping();
    }

    @Override
    public void finish() {
        EntityMangerConfiguration.close();
    }
}
