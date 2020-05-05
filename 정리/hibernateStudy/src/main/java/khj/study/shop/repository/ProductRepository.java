package khj.study.shop.repository;

import khj.study.configuration.EntityMangerConfiguration;
import khj.study.shop.entity.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductRepository {
    private EntityManager entityManager;
    private static ProductRepository productRepository = new ProductRepository();

    public static ProductRepository getInstance() {
        return productRepository;
    }

    public void saveAll(List<Product> products) {
        entityManager = EntityMangerConfiguration.getEntityManger();
        entityManager.getTransaction().begin();

        products.forEach(entityManager::persist);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Product> findAll() {
        entityManager = EntityMangerConfiguration.getEntityManger();
        entityManager.getTransaction().begin();

        List<Product> result = entityManager.createQuery( "from Product", Product.class ).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return result;
    }
}
