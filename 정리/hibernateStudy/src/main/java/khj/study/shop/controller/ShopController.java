package khj.study.shop.controller;

import khj.study.shop.entity.Product;
import khj.study.shop.model.CartDto;
import khj.study.shop.model.OrderDto;
import khj.study.shop.model.PurchaseResult;

import java.util.List;

public interface ShopController {
    List<Product> getProductAll();
    OrderDto addOrder(Long productId, int quantity);
    CartDto getCart();
    PurchaseResult purchase();
}
