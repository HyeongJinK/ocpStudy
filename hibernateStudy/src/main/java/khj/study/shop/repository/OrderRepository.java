package khj.study.shop.repository;

import khj.study.shop.entity.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> findByProductId(Long productId);
}
