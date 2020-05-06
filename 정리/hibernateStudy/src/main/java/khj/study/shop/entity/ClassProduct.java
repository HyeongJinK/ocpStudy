package khj.study.shop.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
public class ClassProduct extends Product {
    public ClassProduct(Long id, String title, BigDecimal price) {
        super(id, title, price, 99999);
    }
}
