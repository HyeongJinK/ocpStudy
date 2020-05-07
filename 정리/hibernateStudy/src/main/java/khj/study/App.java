package khj.study;

import khj.study.shop.controller.ShopController;
import khj.study.shop.controller.ShopControllerImpl;
import khj.study.shop.entity.Product;
import khj.study.shop.model.CartDto;
import khj.study.shop.model.OrderDto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

/**
 * 프로그램 시작
 * I/O 처리
 * */
public class App
{
    static ShopController shopController = ShopControllerImpl.getInstance();

    public static void main( String[] args )
    {
        productsDraw(shopController.getProductAll());

        actionChoice();

    }

    /**
     * 상품 출력
     * */
    private static void productsDraw(List<Product> products) {
        System.out.println("상품번호\t\t\t\t\t\t\t\t\t\t상품명\t\t\t\t\t\t\t\t\t\t판매가격\t재고수");
        products.stream().forEach(Product::draw);
    }
    /**
     * 액션 선택
     * */
    private static void actionChoice() {
        Scanner sc = new Scanner(System.in);
        String status = "";

        while (!isQuit(status)) {
            System.out.print("입력(o[order]: 주문, q[quit]: 종료  :" );
            status = sc.next();

            if (isOrder(status)) {
                ordering();
                drawOrder(shopController.getCart());
            } else if (isQuit(status)) {
                quit();
            } else {
                failInput();
            }
        }
    }
    /**
     * 주문
     * */
    private static void ordering() {
        Scanner sc = new Scanner(System.in);
        String id = "";
        int quantity = 0;

        while(true) {
            System.out.print("상품번호 : ");
            id = sc.nextLine();
            if (id.equals(" ")) break;

            System.out.print("수량 : ");
            quantity = Integer.parseInt(sc.nextLine());
            OrderDto result = shopController.addOrder(Long.parseLong(id), quantity);
            if (!result.getMessage().equals("")) {
                System.out.println(result.getMessage());
            }
        }
    }

    private static void drawOrder(CartDto cartDTO) {
        System.out.println("주문 내역:");
        System.out.println("------------------------------------------------------------------");
        cartDTO.getCarts().stream()
                .forEach(cart -> System.out.println(cart.getProduct().getTitle() + " - " +cart.getQuantity()));
        System.out.println("------------------------------------------------------------------");
        System.out.print("주문금액: ");
        System.out.println(toNumFormat(cartDTO.getOrderPrice()));
        drawDelivery(cartDTO.getDeliveryFee());
        System.out.println("------------------------------------------------------------------");
        System.out.print("지불금액: ");
        System.out.println(toNumFormat(cartDTO.getPayPrice()));
        System.out.println("------------------------------------------------------------------");
    }

    private static String toNumFormat(long price) {
        DecimalFormat df = new DecimalFormat("#.###");
        return df.format(price);
    }

    private static void drawDelivery(long delivery) {
        if (delivery != 0) {
            System.out.print("배송비: ");
            System.out.println(toNumFormat(delivery));
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
        System.exit(0);
    }
}
