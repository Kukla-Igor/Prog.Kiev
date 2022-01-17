package ua.kiev.prog.DAO;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


public abstract class AbstractDAO<T> {
    static EntityManagerFactory emf;
    static EntityManager em;
    private final String table;

    public AbstractDAO(String table) {
        this.table = table;
        emf = Persistence.createEntityManagerFactory("Store");
        em = emf.createEntityManager();
    }



    public void add(T t) {
        em.getTransaction().begin();
        try {
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    public void delete(T t) {
        em.getTransaction().begin();
        try {
            em.remove(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }


    public void update(T t) {
        em.getTransaction().begin();
        try {
            em.refresh(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    public List<T> getAll(Class<T> cls) {

        try {
            TypedQuery <T> query = em.createQuery("SELECT c FROM " + cls.getName() +" c", cls);

            return  query.getResultList();
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

}
