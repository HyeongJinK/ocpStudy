package khj.study.configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityMangerConfiguration {
    private final static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "khj.study.real" );

    public static EntityManager getEntityManger() {
        return entityManagerFactory.createEntityManager();
    }

    public static void close() {
        entityManagerFactory.close();
    }
}
