package main.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import main.Subscription;

import java.util.List;

public class SubscriptionRepository {
    private EntityManagerFactory factory;

    public SubscriptionRepository( ) {
        factory = Persistence.createEntityManagerFactory("uni7-pu");
    }

    public Subscription create(Subscription subscription) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(subscription);
        em.getTransaction().commit();

        return subscription;
    }

    public Subscription findById(Long id) {
        EntityManager em = factory.createEntityManager();
        return em.find(Subscription.class, id);
    }

    public List<Subscription> findAll() {
        EntityManager em = factory.createEntityManager();
        TypedQuery<Subscription> query = em.createQuery("SELECT s FROM Subscription s", Subscription.class);
        List<Subscription> subscriptions = query.getResultList();
        return subscriptions;
    }

    public Subscription delete(Long id) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Subscription subscription = em.find(Subscription.class, id);
        if (subscription != null){
            em.remove(subscription);
        }

        em.getTransaction().commit();

        return subscription;
    }

    public Subscription update(Subscription subscription) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Subscription fromDB = em.find(Subscription.class, subscription.getId());
        if (fromDB != null) {
            fromDB.setPayment(subscription.getPayment());
            fromDB.setStartDate(subscription.getStartDate());

            em.merge(fromDB);
        }

        em.getTransaction().commit();

        return fromDB;
    }

    public List<Subscription> findByPaymentLowerThan(Double payment) {
        EntityManager em = factory.createEntityManager();

        TypedQuery<Subscription> query = em.createQuery(
                "select s from Subscription s where s.payment < :payment", Subscription.class);
        query.setParameter("payment", payment);
        List<Subscription> result = query.getResultList();
        em.close();
        return result;
    }
}
