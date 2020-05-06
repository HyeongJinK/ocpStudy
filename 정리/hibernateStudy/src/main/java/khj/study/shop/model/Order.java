package khj.study.shop.model;

import lombok.Getter;

@Getter
public class Order {
    Long productId;
    int quantity;

    public Order(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
