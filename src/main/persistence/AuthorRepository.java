package main.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import main.Author;
import main.Subscription;

import java.util.List;

public class AuthorRepository {
    private EntityManagerFactory factory;

    public AuthorRepository( ) {
        factory = Persistence.createEntityManagerFactory("uni7-pu");
    }

    public Author create(Author author) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(author);
        em.getTransaction().commit();

        return author;
    }

    public Author findById(Long id) {
        EntityManager em = factory.createEntityManager();
        return em.find(Author.class, id);
    }

    public List<Author> findAll() {
        EntityManager em = factory.createEntityManager();
        TypedQuery<Author> query = em.createQuery("SELECT a FROM Author a", Author.class);
        List<Author> authors = query.getResultList();
        return authors;
    }

    public Author delete(Long id) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Author author = em.find(Author.class, id);
        if (author != null){
            em.remove(author);
        }

        em.getTransaction().commit();

        return author;
    }

    public Author update(Author author) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Author fromDB = em.find(Author.class, author.getId());
        if (fromDB != null) {
            fromDB.setFirstName(author.getFirstName());
            fromDB.setLastName(author.getLastName());

            em.merge(fromDB);
        }

        em.getTransaction().commit();

        return fromDB;
    }

}
