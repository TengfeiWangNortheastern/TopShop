/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao;

import com.mycompany.dao.ProductDAO;
import com.mycompany.dao.UserDAO;
import com.mycompany.pojo.Product;
import com.mycompany.pojo.User;
import org.junit.Test;

/**
 *
 * @author Fei
 */
public class MainClass {
    
    @Test
    public void productTest() {
        Product product=new Product();
        product.setName("Harry Potter");
        product.setPrice(12);
        product.setReviewCount(2);
        product.setSale(100);
        product.setStock(1000);
        ProductDAO productDAO=new ProductDAO();
        productDAO.createProduct(product);
    }

    @Test
    public void userTest() {
        User user=new User();
        user.setName("admin");
        user.setPassword("admin");
        UserDAO userDAO=new UserDAO();
        userDAO.createUser(user);
    }

    @Test
    public void entitest(){

    }
}
