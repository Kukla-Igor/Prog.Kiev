package ua.kiev.prog.DAO;

import ua.kiev.prog.entity.Order;

import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class OrderDAO extends AbstractDAO<Order> {
    public OrderDAO(String table) {
        super(table);
    }

    public List<Order> findOrderByPhone(int num) {

        try {
            TypedQuery<Order> query = em.createQuery("SELECT c FROM Order c  WHERE c.client.PhoneNum = :num ", Order.class);
            query.setParameter("num", num);

            return  query.getResultList();
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public List<Order> findOrderByDates(Date first, Date second) {

        try {
            TypedQuery<Order> query = em.createQuery("SELECT c FROM Order c  WHERE c.date >= :first AND c.date <= :second ", Order.class);
            query.setParameter("first", first);
            query.setParameter("second", second);

            return  query.getResultList();
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }
}
