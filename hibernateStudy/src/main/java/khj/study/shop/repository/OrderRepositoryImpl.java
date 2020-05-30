package khj.study.shop.repository;

import khj.study.configuration.EntityMangerConfiguration;
import khj.study.shop.entity.Order;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderRepositoryImpl implements OrderRepository {
    private EntityManager entityManager;
    private static OrderRepositoryImpl  orderRepositoryImpl = new OrderRepositoryImpl();

    public static OrderRepositoryImpl getInstance() { return orderRepositoryImpl; }
    @Override
    public List<Order> findByProductId(Long productId) {
        String sql = "select o from Order o join o.product p where p.id = :id";
        entityManager = EntityMangerConfiguration.getEntityManger();
        entityManager.getTransaction().begin();

        TypedQuery<Order> query = entityManager.createQuery(sql, Order.class);
        query = query.setParameter("id", productId);

        List<Order> orders = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return orders;
    }
}
