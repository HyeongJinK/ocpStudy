package khj.study.shop.entity;

import javax.persistence.*;

//@Entity
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
