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
    }

    @Override
    public void order() {

    }
}
