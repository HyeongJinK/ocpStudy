package khj.study.shop.repository;

import khj.study.configuration.EntityMangerConfiguration;
import khj.study.shop.entity.Purchase;

import javax.persistence.EntityManager;
import java.util.List;

public class PurchaseRepositoryImpl implements PurchaseRepository {
    private EntityManager entityManager;
    private static PurchaseRepositoryImpl purchaseRepositoryImpl = new PurchaseRepositoryImpl();

    public static PurchaseRepositoryImpl getInstance() { return purchaseRepositoryImpl; }

    @Override
    public List<Purchase> findAll() {
        entityManager = EntityMangerConfiguration.getEntityManger();
        entityManager.getTransaction().begin();

        List<Purchase> result = entityManager.createQuery("from Purchase", Purchase.class).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return result;
    }

    @Override
    public void save(Purchase purchase) {
        entityManager = EntityMangerConfiguration.getEntityManger();
        entityManager.getTransaction().begin();

        entityManager.persist(purchase);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
