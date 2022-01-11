package ua.kiev.prog;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Date;


public abstract class AbstractDAO<T> {
    static EntityManagerFactory emf;
    static EntityManager em;
    private final String table;

    public AbstractDAO(String table) {
        this.table = table;
        emf = Persistence.createEntityManagerFactory("JPAAPIPB");
        em = emf.createEntityManager();
    }



    public void add(T t) {
        em.getTransaction().begin();
        try {
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }



    public float getSaleRateNBByDate(Date date) {

        try {
            Query query = em.createQuery(
                    "SELECT c.saleRateNB FROM " + table +" c WHERE c.date = :date", Float.class);
            query.setParameter("date", date);

            return  (float) query.getSingleResult();
        } catch (Exception ex) {
            System.out.println(ex);
            return 0;
        }
    }

}
