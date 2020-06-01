package khj.study.shop.repository;

import khj.study.shop.entity.Cart;

import java.util.List;

public interface CartRepository {
    List<Cart> findAll();
    void save(Cart cart);
    void deleteAll();
}
