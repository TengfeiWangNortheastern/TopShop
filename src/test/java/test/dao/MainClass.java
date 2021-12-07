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
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.junit.Test;

/**
 *
 * @author Fei
 */
public class MainClass {
    
    @Test
    public void productTest() {
        Product product=new Product();
        product.setName("HPWatch");
        product.setPrice(12.0);
        product.setReviewCount(2);
        product.setSale(100);
        product.setStock(1000);
        product.setSubTitle("watch");
        ProductDAO productDAO=new ProductDAO();
        productDAO.createProduct(product);
    }
    @Test
    public void deleteproductTest() {
        ProductDAO productDAO=new ProductDAO();
        Product harry_potter = productDAO.getProductByName("Harry Potter");
        System.out.println(harry_potter.getId());
//        productDAO.deleteProductById(harry_potter.getId());
    }
    @Test
    public void userTest() {
        User user=new User();
        user.setName("admin");
        user.setPassword("admin");
        UserDAO userDAO=new UserDAO();
//        userDAO.createUser(user);
    }

    @Test
    public void getProuctTest(){
        int id=1;
        ProductDAO productDAO=new ProductDAO();
        Product product = productDAO.getProductByID(id);
        System.out.println(product.getName());
    }
}
