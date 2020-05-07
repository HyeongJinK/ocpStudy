package khj.study.shop.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Order {
    @Id @GeneratedValue
    Long id;
    @OneToOne
    Product product;
    int quantity;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "purchase_id")
    Purchase purchase;

}
