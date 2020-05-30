package khj.study.shop.model;

import khj.study.shop.entity.Cart;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class CartDto {
    List<Cart> carts;
    long orderPrice;

    public CartDto(List<Cart> carts) {
        this.carts = carts;
        this.orderPrice = carts.stream()
                .mapToLong(cart -> cart.getProduct().getPrice().multiply(new BigDecimal(cart.getQuantity())).longValue())
                .sum();
    }

    public long getDeliveryFee() {
        if (this.orderPrice >= 50000) {
            return 0L;
        } else {
            return 5000L;
        }
    }

    public long getPayPrice() {
        return orderPrice + getDeliveryFee();
    }
}
