package com.rafaelcarlos.positivo.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rafaellcarloss
 * @since 12/12/2015
 */
public class JpaUtil {

    private static final String PERSISTENCE_UNIT = "positivoWS";
    private static final ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<>();
    private static EntityManagerFactory entityManagerFactory;

    private JpaUtil() {
    }

    public static ThreadLocal<EntityManager> getThreadEntityManager() {
        return threadEntityManager;
    }

    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            entityManagerFactory
                    = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        EntityManager entityManager = threadEntityManager.get();
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = entityManagerFactory.createEntityManager();
            JpaUtil.threadEntityManager.set(entityManager);
        }

        return entityManager;
    }

    public static void closeEntityManagerFactory() {
        entityManagerFactory.close();
    }
}
