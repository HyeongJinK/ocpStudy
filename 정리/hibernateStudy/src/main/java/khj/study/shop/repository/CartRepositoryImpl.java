package khj.study.shop.repository;

import khj.study.configuration.EntityMangerConfiguration;
import khj.study.shop.entity.Cart;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CartRepositoryImpl implements CartRepository {
    private EntityManager entityManager;
    private static CartRepositoryImpl cartRepositoryImpl = new CartRepositoryImpl();

    public static CartRepositoryImpl getInstance() { return cartRepositoryImpl; }

    @Override
    public List<Cart> findAll() {
        entityManager = EntityMangerConfiguration.getEntityManger();
        entityManager.getTransaction().begin();

        List<Cart> result = entityManager.createQuery( "from Cart", Cart.class ).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return result;
    }

    @Override
    public void save(Cart cart) {
        entityManager = EntityMangerConfiguration.getEntityManger();
        entityManager.getTransaction().begin();

        entityManager.persist(cart);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteAll() {
        entityManager = EntityMangerConfiguration.getEntityManger();
        entityManager.getTransaction().begin();

        entityManager.createQuery("delete from Cart").executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
