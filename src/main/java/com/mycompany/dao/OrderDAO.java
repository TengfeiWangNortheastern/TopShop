package com.mycompany.dao;

import com.mycompany.pojo.Orderitem;
import com.mycompany.pojo.Orders;

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
    public void createOrderitem(Orderitem orderitem){
        try {
            begin();
            getSession().save(orderitem);
            commit();
            System.out.println("orderitem saved in the DB");
        } catch (Exception e) {
//            rollback();
            System.out.println("orderitem not saved in the DB");
        }
    }
}
