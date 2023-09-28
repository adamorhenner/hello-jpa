package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseGen {

    public static void main(String[] args) {
        String persistenceUnitName = "uni7-pu";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Subscription s1 = new Subscription(null, null, 10.9);
        em.persist(s1);
        em.getTransaction().commit();

        em.close();

        emf.close();
    }
}
