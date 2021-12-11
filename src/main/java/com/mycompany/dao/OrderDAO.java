package com.mycompany.dao;

import com.mycompany.pojo.Order;
import com.mycompany.pojo.Order;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.util.List;

public class OrderDAO extends DAO{
    public List<Order> displayOrderList(){
        try {
            begin();
            List<Order> list = getSession().createQuery("from Order").list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not get all order" +  e.getMessage());
            return null;
        }
    }
    public List<Order> displayOrderList(int id){
        try {
            begin();
            List<Order> list = getSession().createQuery("from Order where userId="+id).list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not get all order" +  e.getMessage());
            return null;
        }
    }

    public Order deleteOrderById(int id){
        try {
            begin();
            Query q = getSession().createQuery("from Order where orderId = " + id);
            Order artist = (Order) q.uniqueResult();
            getSession().delete(artist);
            commit();
            return artist;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not delete order: " + id +  e.getMessage());
            return null;
        }
    }

    public void delete(Order user) {
        try {
            begin();
            getSession().delete(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not delete order " +  e.getMessage());
        }
    }

    public void createOrder(Order order) {

        try {
            begin();
            getSession().save(order);
            commit();
            System.out.println("order saved in the DB");
        } catch (Exception e) {
            rollback();
            System.out.println("order not saved in the DB");
        }
    }

    public void updateOrder(Order product){
        try {
            begin();
            getSession().update(product);
            commit();
        }
        catch (HibernateException e) {
            rollback();
            System.out.println("Could not update order: " +  e.getMessage());
        }
    }

    public Order getOrderByName(String s){
        try {
            begin();
            Query query = getSession().createQuery("from Order where recipientName=:name");
            query.setString("name",s);
            Order product=(Order) query.uniqueResult();
            close();
            return product;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not get order " +  e.getMessage());
            return null;
        }

    }
    public Order getOrderByID(int id){
        try {
            begin();
            Query query = getSession().createQuery("from Order where orderId=:name");
            query.setInteger("name",id);
            Order product=(Order) query.uniqueResult();
            close();
            return product;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not get order " +  e.getMessage());
            return null;
        }

    }
}
