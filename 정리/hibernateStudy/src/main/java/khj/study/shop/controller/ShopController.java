package khj.study.shop.controller;

import khj.study.shop.entity.Product;
import khj.study.shop.model.Order;

import java.util.List;

public interface ShopController {
    List<Product> getProductAll();
    void order(List<Order> orders);
}
