package khj.study.shop.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
public class KitProduct extends Product {
    public KitProduct(Long id, String title, BigDecimal price, int stock) {
        super(id, title, price, stock);
    }
}
