package khj.study.shop.entity;

import khj.study.shop.model.ProductCheckResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    protected Long id;
    protected String title;
    protected BigDecimal price;
    protected int stock;

    public void draw() {
        System.out.printf("%7d %-60s %7d %5d\n", id, title, price.stripTrailingZeros().longValue(), stock);
        //System.out.println(product.getId() + " " + product.getTitle() + "\t" + product.getPrice().stripTrailingZeros() + "\t" + product.getStock());
    }

    public ProductCheckResult quantityCheck(int quantity) {
        return new ProductCheckResult(true, "success");
    }

    public ProductCheckResult beforePurchaseCheck(List<Order> orders) {
        return new ProductCheckResult(true, "success");
    }

}
