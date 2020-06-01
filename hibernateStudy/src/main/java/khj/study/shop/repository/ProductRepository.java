package khj.study.shop.repository;

import khj.study.shop.entity.Product;

import java.util.List;

public interface ProductRepository {
    void saveAll(List<Product> products);
    List<Product> findAll();
    Product findById(Long id);
}
