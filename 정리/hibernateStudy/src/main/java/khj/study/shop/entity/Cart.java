package khj.study.shop.entity;

import lombok.Getter;

import java.util.List;

@Getter
public class Cart {
    List<Order> orders;

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void drawOrders() {
        System.out.println("주문내역");
        System.out.println("---------------------------------------------------");
        orders.stream().forEach(order -> {
            //System.out.println(orde);
        });
        System.out.println("---------------------------------------------------");
    }
}
