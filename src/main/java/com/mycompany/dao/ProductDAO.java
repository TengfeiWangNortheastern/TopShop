/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.pojo.Product;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import java.util.List;

/**
 *
 * @author Fei
 */
public class ProductDAO extends DAO{

    public List<Product> displayProductList(){
        try {
            begin();
            List<Product> list = getSession().createQuery("from Product").list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not get all product" +  e.getMessage());
            return null;
        }
    }

    public Product deleteProductById(int id){
        try {
            begin();
            Query q = getSession().createQuery("from Product where id = " + id);
            Product artist = (Product) q.uniqueResult();
            getSession().delete(artist);
            commit();
            return artist;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not delete product: " + id +  e.getMessage());
            return null;
        }
    }

    public void delete(Product user) {
        try {
            begin();
            getSession().delete(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not delete product " +  e.getMessage());
        }
    }

    public void createProduct(Product product) {
        try {
            begin();
            getSession().save(product);
            commit();
        } catch (Exception e) {
            rollback();
        }

        System.out.println("product saved in the DB");
    }

    public void updateProduct(Product product){
        try {
            begin();
            getSession().update(product);
            commit();
        }
        catch (HibernateException e) {
            rollback();
            System.out.println("Could not update product: " +  e.getMessage());
        }
    }
    public List<Product> searchProductListByKeyWord(String s){
        try {
            begin();
            Query query = getSession().createQuery("from Product where name like :name");
            String keywords="%"+s+"%";
            query.setString("name",keywords);
            List<Product> list = query.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not get products" +  e.getMessage());
            return null;
        }
    }

    public Product getProductByName(String s){
        try {
            begin();
            Query query = getSession().createQuery("from Product where name=:name");
            query.setString("name",s);
            Product product=(Product) query.uniqueResult();
            close();
            return product;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not get product " +  e.getMessage());
            return null;
        }
    }
    public Product getProductByID(int id){
        try {
            begin();
            Query query = getSession().createQuery("from Product where id=:name");
            query.setInteger("name",id);
            Product product=(Product) query.uniqueResult();
            close();
            return product;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not get product " +  e.getMessage());
            return null;
        }

    }


}
