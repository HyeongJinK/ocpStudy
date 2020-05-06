package khj.study.shop.controller;

import khj.study.shop.entity.Product;
import khj.study.shop.model.Order;
import khj.study.shop.service.ShopService;
import khj.study.shop.service.ShopServiceImpl;

import java.util.List;

/**
 * 샵 컨트롤러
 * */
public class ShopControllerImpl implements ShopController {
    private static final ShopControllerImpl shopController = new ShopControllerImpl();
    private ShopService shopService;

    private ShopControllerImpl() {
        shopService = ShopServiceImpl.getInstance();
    }

    public static ShopControllerImpl getInstance() {
        return shopController;
    }

    @Override
    public List<Product> getProductAll() {
        return shopService.getProductAll();
    }

    @Override
    public void order(List<Order> orders) {

    }


}
