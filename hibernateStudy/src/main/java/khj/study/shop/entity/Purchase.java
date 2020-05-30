package khj.study.shop.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Purchase {
    @Id @GeneratedValue
    Long id;
    @OneToMany(mappedBy = "purchase")
    List<Order> orders = new ArrayList<>();
}
