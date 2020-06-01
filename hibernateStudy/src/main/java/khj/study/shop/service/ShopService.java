package khj.study.shop.service;

import khj.study.shop.entity.Product;
import khj.study.shop.model.CartDto;

import java.util.List;

public interface ShopService {
    List<Product> getProductAll();
    void addOrder(Long productId, int quantity);
    CartDto getCartAll();
    void purchase();
}
