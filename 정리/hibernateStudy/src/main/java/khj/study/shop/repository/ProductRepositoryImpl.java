package khj.study.shop.repository;

import khj.study.configuration.EntityMangerConfiguration;
import khj.study.shop.entity.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private EntityManager entityManager;
    private static ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl();

    public static ProductRepositoryImpl getInstance() {
        return productRepositoryImpl;
    }

    @Override
    public void saveAll(List<Product> products) {
        entityManager = EntityMangerConfiguration.getEntityManger();
        entityManager.getTransaction().begin();

        products.forEach(entityManager::persist);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Product> findAll() {
        entityManager = EntityMangerConfiguration.getEntityManger();
        entityManager.getTransaction().begin();

        List<Product> result = entityManager.createQuery( "from Product", Product.class ).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return result;
    }

    @Override
    public Product findById(Long id) {
        entityManager = EntityMangerConfiguration.getEntityManger();
        entityManager.getTransaction().begin();

        Product result = entityManager.find(Product.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }
}
