package khj.study.shop.service;

import khj.study.shop.entity.Cart;
import khj.study.shop.entity.Order;
import khj.study.shop.entity.Product;

import java.util.List;
import java.util.Scanner;

public class OrderServiceImpl implements OrderService {
    private static final OrderServiceImpl orderService = new OrderServiceImpl();

    private OrderServiceImpl() { }

    public static OrderServiceImpl getInstance() {
        return orderService;
    }

    private static void order(List<Product> products) {
        Cart cart = new Cart();
        Scanner sc = new Scanner(System.in);
        String id = "";
        int quantity = 0;

        //productsDraw(products);

        while(true) {
            System.out.print("상품번호 : ");
            id = sc.next();
            if (id.equals(" ")) break;

            System.out.print("수량 : ");
            quantity = sc.nextInt();

            cart.addOrder(new Order(null, quantity));
        }
        cart.drawOrders();
    }

    @Override
    public void order() {

    }
}
