package khj.study.shop.service;

import khj.study.shop.entity.Cart;
import khj.study.shop.entity.ClassProduct;
import khj.study.shop.entity.KitProduct;
import khj.study.shop.entity.Product;
import khj.study.shop.repository.ProductRepositoryImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private static ShopService shopService = new ShopServiceImpl();
    private final ProductRepositoryImpl productRepositoryImpl;
    Cart cart = new Cart();

    private ShopServiceImpl() {
        productRepositoryImpl = ProductRepositoryImpl.getInstance();
        setInitProductData();
    }

    public static ShopService getInstance() {
        return shopService;
    }


    @Override
    public List<Product> getProductAll() {
        return productRepositoryImpl.findAll();
    }

    @Override
    public void shopping() {
        //productsDraw(productRepository.findAll());


//        Scanner sc = new Scanner(System.in);
//        String status = "";
//
//        while (!isQuit(status)) {
//            System.out.print("입력(o[order]: 주문, q[quit]: 종료  :" );
//            status = sc.next();
//
//            if (isOrder(status)) {
//                //order(products);
//            } else if (isQuit(status)) {
//                quit();
//            } else {
//                failInput();
//            }
//        }
    }

    @Override
    public void order() {

    }

    /**
     * 데이터 초기화
     * */
    private void setInitProductData() {
        List<Product> products = new ArrayList<>();
        products.add(new ClassProduct(16374l, "스마트스토어로 월 100만원 만들기, 평범한 사람이 돈을 만드는 비법", new BigDecimal(151950)));
        products.add(new ClassProduct(26825l, "해금, 특별하고 아름다운 나마의 반려악기", new BigDecimal(114500)));
        products.add(new ClassProduct(65625l, "일상에 따뜻한 숨결을 불어넣어요, 반지수와 함께하는 아이패드 드로잉", new BigDecimal(174500)));
        products.add(new KitProduct(91008l, "작고 쉽게 그려요 - 부담없이 시작하는 수채화 미니 키트", new BigDecimal(28000), 10));
        products.add(new KitProduct(9236l, "하루의 시작과 끝, 욕실의 포근함을 선사하는 천연 비누", new BigDecimal(9900), 22));
        products.add(new ClassProduct(55527l, "코바늘로 인형을 만들자! 시은맘의 꼼지락 작업실", new BigDecimal(299500)));
        products.add(new ClassProduct(2344l, "일상 유튜버 슛뚜의 감성을 그대로, 영화같은 브이로그 제작법", new BigDecimal(184500)));
        products.add(new KitProduct(60538l, "시작에 대한 부담을 덜다. 가격 절약 아이패드 특가전", new BigDecimal(135800), 7));
        products.add(new KitProduct(78156l, "일상을 따뜻하게 채우는 썬캐쳐와 무드등", new BigDecimal(45000), 16));
        products.add(new ClassProduct(53144l, "여행 드로잉, 꿈만 꾸지 마세요. 핀든아트와 여행, 그리다", new BigDecimal(249500)));
        products.add(new ClassProduct(78311l, "사각사각 손글씨의 낭만, 펜크래프트의 한글 정자체 펜글씨", new BigDecimal(209500)));
        products.add(new KitProduct(97166l, "이렇게 멋진 수채화 키트, 어때요? 클래스101과 고넹이화방이 기획한 3가지 수채화 키트", new BigDecimal(96900), 5));
        products.add(new ClassProduct(83791l, "월급으로 만족하지 못하는 분들을 위한 아마존/이베이 입문", new BigDecimal(178500)));
        products.add(new KitProduct(58395l, "선과 여백으로 채우는 2020년 캘린더와 엽서", new BigDecimal(18620), 31));
        products.add(new KitProduct(39712l, "집에서 느끼는 겨울의 묵직한 포근함, 플랜테리어 아이템", new BigDecimal(17600), 8));
        products.add(new ClassProduct(96558l, "사진 입문자를 위한 쉽게 배우고 빨리 써먹는 사진과 라이트룸", new BigDecimal(234500)));
        products.add(new KitProduct(42031l, "나만의 음악을 만들기 위한 장비 패키지", new BigDecimal(209000), 2));
        products.add(new ClassProduct(45947l, "일러스트레이터 집시의 매력적인 얼굴 그리기", new BigDecimal(249500)));
        products.add(new ClassProduct(74218l, "나만의 문방구를 차려요! 그리지영의 타블렛으로 굿즈 만들기", new BigDecimal(191600)));
        products.add(new ClassProduct(28448l, "당신도 할 수 있다! 베테랑 실무자가 알려주는 모션그래픽의 모든 것", new BigDecimal(152200)));
        productRepositoryImpl.saveAll(products);
    }
}
