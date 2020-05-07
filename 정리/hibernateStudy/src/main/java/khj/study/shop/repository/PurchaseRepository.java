package khj.study.shop.repository;

import khj.study.shop.entity.Purchase;

import java.util.List;

public interface PurchaseRepository {
    List<Purchase> findAll();
    void save(Purchase purchase);
}
