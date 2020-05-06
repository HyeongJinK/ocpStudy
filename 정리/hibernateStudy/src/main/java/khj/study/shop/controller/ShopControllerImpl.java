package khj.study.shop.controller;

import khj.study.shop.entity.Cart;
import khj.study.shop.entity.Order;
import khj.study.shop.entity.Product;
import khj.study.shop.service.ShopService;
import khj.study.shop.service.ShopServiceImpl;

import java.util.List;
import java.util.Scanner;

/**
 * 샵 컨트롤러
 * */
public class ShopControllerImpl implements ShopController {
    private static final ShopControllerImpl shopController = new ShopControllerImpl();
    private ShopService shopService;

    private ShopControllerImpl() {
        shopService = ShopServiceImpl.getInstance();
    }

    public static ShopControllerImpl getInstance() {
        return shopController;
    }
    /**
     * 쇼핑 시작
     * */
    @Override
    public void shopping() {
        productsDraw(shopService.getProductAll());
        actionChoice();
    }

    @Override
    public void ordering() {
        Scanner sc = new Scanner(System.in);
        String id = "";
        int quantity = 0;

        //productsDraw(products);

        while(true) {
            System.out.print("상품번호 : ");
            id = sc.next();
            if (id.equals("")) break;

            System.out.print("수량 : ");
            quantity = sc.nextInt();

            cart.addOrder(new Order(null, quantity));
        }
        cart.drawOrders();
    }

    private void actionChoice() {
        Scanner sc = new Scanner(System.in);
        String status = "";

        while (!isQuit(status)) {
            System.out.print("입력(o[order]: 주문, q[quit]: 종료  :" );
            status = sc.next();

            if (isOrder(status)) {
                ordering();
            } else if (isQuit(status)) {
                quit();
            } else {
                failInput();
            }
        }
    }

    private static boolean isOrder(String status) {
        status = status.toLowerCase();
        return status.equals("o") || status.equals("order");
    }

    private static boolean isQuit(String status) {
        status = status.toLowerCase();
        return status.equals("q") || status.equals("quit");
    }

    private static void failInput() {
        System.out.println("잘못된 입력입니다.");
    }

    private static void quit() {
        System.out.println("고객님의 주문 감사합니다.");
    }

    /**
     * 상품 출력
     * */
    private void productsDraw(List<Product> products) {
        System.out.println("상품번호\t\t\t\t\t\t\t\t\t\t상품명\t\t\t\t\t\t\t\t\t\t판매가격\t재고수");
        products.stream().forEach(Product::draw);
    }
}
