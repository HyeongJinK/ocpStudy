package khj.study.shop.entity;

import khj.study.shop.model.ProductCheckResult;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
public class ClassProduct extends Product {
    public ClassProduct(Long id, String title, BigDecimal price) {
        super(id, title, price, 99999);
    }

    @Override
    public ProductCheckResult quantityCheck(int quantity) {
        if (quantity > 1) {
            return new ProductCheckResult(false, "클래스 상품은 하나만 주문할 수 있습니다.");
        }
        return new ProductCheckResult(true, "success");
    }

    @Override
    public ProductCheckResult beforePurchaseCheck(List<Order> orders) {
        if (orders != null && orders.size() > 0) {
            return new ProductCheckResult(false, "이 클래스 상품은 이미 구입하였습니다.");
        }
        return new ProductCheckResult(true, "success");
    }
}
