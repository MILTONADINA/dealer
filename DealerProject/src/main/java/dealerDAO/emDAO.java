package dealerDAO;
import jakarta.persistence.*;

// entity manager factory provider
public class emDAO {
    
    private static EntityManagerFactory entityManagerFactory;
    
    public static void initEM() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("Dealer");
        }
    }
    
    public static EntityManager getEM() {
        if (entityManagerFactory == null) {
            initEM();
        }
        return entityManagerFactory.createEntityManager();
    }
    
    public static void close() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

}
