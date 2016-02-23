package server.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by maks(avto12@i.ua) on 07.02.2016.
 */
public class HibernateUtil {

    private static final String PERSISTENT_UNIT_NAME = "userService";

    private static final EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEm() {
        return emf.createEntityManager();
    }
}
