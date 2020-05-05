package khj.study;

import khj.study.configuration.EntityMangerConfiguration;
import khj.study.shop.service.ShopService;
import khj.study.shop.service.ShopServiceImpl;

public class MainServiceImpl implements MainService {
    private static MainServiceImpl mainService = new MainServiceImpl();

    private final ShopService shopService;

    public MainServiceImpl() {
        shopService = ShopServiceImpl.getInstance();
    }

    public static MainService getInstance() {
        return mainService;
    }

    @Override
    public void start() {
        shopService.shopping();
    }

    @Override
    public void finish() {
        EntityMangerConfiguration.close();
    }
}
