package com.mycompany.dao;

import com.mycompany.pojo.Orderitem;
import com.mycompany.pojo.Orders;
import com.mycompany.pojo.Product;
import com.mycompany.pojo.User;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class OrderDAO extends DAO{
//    public List<Order> displayOrderList(){
//        try {
//            begin();
//            List<Order> list = getSession().createQuery("from Order").list();
//            commit();
//            return list;
//        } catch (HibernateException e) {
//            rollback();
//            System.out.println("Could not get all order" +  e.getMessage());
//            return null;
//        }
//    }
//    public List<Order> displayOrderList(int id){
//        try {
//            begin();
//            List<Order> list = getSession().createQuery("from Order where userId="+id).list();
//            commit();
//            return list;
//        } catch (HibernateException e) {
//            rollback();
//            System.out.println("Could not get all order" +  e.getMessage());
//            return null;
//        }
//    }
//
//    public Order deleteOrderById(int id){
//        try {
//            begin();
//            Query q = getSession().createQuery("from Order where orderId = " + id);
//            Order artist = (Order) q.uniqueResult();
//            getSession().delete(artist);
//            commit();
//            return artist;
//        } catch (HibernateException e) {
//            rollback();
//            System.out.println("Could not delete order: " + id +  e.getMessage());
//            return null;
//        }
//    }
//
//    public void delete(Order user) {
//        try {
//            begin();
//            getSession().delete(user);
//            commit();
//        } catch (HibernateException e) {
//            rollback();
//            System.out.println("Could not delete order " +  e.getMessage());
//        }
//    }

    public void createOrder(Orders order) {

        try {
            begin();
            getSession().save(order);
            commit();
            System.out.println("order saved in the DB");
        } catch (Exception e) {
//            rollback();
            System.out.println("order not saved in the DB");
        }
    }
    public List<Orders> getOrdersByUserId(int id){
        try {
            begin();
            Query query = getSession().createQuery("from Orders where userId=:name");
            query.setInteger("name",id);
            List<Orders> ordersList=(List<Orders>) query.uniqueResult();
            commit();
            System.out.println("got user orders");
            return ordersList;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not get user orders " +  e.getMessage());
            return null;
        }
    }
    public Orders getOrdersById(int id){
        try {
            begin();
            Criteria criteria=getSession().createCriteria(Orders.class);
            criteria.add(Restrictions.eq("id",id));
            Orders orders=(Orders) criteria.uniqueResult();
            commit();
            System.out.println("got user orders");
            return orders;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not get user orders " +  e.getMessage());
            return null;
        }
    }
    public List<Orderitem> getOrderItemsByOrderId(int id){
        try {
            begin();
            Query query = getSession().createQuery("from Orderitem where id=:name");
            query.setInteger("name",id);
            List<Orderitem> ordersList=query.list();
            commit();
            System.out.println("got user orders by orderID");
            return ordersList;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not get user orders " +  e.getMessage());
            return null;
        }
    }
    public List<Orders> getAllOrders(String status){
        try {
            begin();
            Query query = getSession().createQuery("from Orders where status=:status");
            query.setString("status",status);
            List<Orders> list=query.list();
            close();
            System.out.println("got user orders");
            return list;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not get user orders " +  e.getMessage());
            return null;
        }
    }
    public List<Orders> getAllOrders(){
        try {
            begin();
            List<Orders> list = getSession().createQuery("from Orders").list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not get all user" +  e.getMessage());
            return null;
        }
    }
}
