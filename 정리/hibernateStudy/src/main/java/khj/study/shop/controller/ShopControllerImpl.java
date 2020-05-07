package khj.study.shop.controller;

import khj.study.exception.NoneProductException;
import khj.study.exception.OrderException;
import khj.study.shop.entity.Product;
import khj.study.shop.model.CartDto;
import khj.study.shop.model.OrderDto;
import khj.study.shop.model.PurchaseResult;
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
    public OrderDto addOrder(Long productId, int quantity) {
        try {
            shopService.addOrder(productId, quantity);
            return new OrderDto();
        } catch (OrderException | NoneProductException e) {
            return new OrderDto(e.getMessage());
        }
    }

    @Override
    public CartDto getCart() {
        return shopService.getCartAll();
    }

    @Override
    public PurchaseResult purchase() {
        return null;
    }


}
