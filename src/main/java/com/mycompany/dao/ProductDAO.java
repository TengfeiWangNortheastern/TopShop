/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.pojo.Product;

/**
 *
 * @author Fei
 */
public class ProductDAO extends DAO{
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
    public void deleteProduct(Product product){
        try{
            begin();
            getSession()
        }catch (Exception e){
            rollback();
        }
    }
}
