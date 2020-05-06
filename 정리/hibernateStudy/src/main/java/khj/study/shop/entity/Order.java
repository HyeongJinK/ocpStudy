package khj.study.shop.entity;

import lombok.Getter;

import javax.persistence.*;

//@Entity
@Getter
public class Order {
  //  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    //@OneToOne
    Product product;
    int quantity;

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
