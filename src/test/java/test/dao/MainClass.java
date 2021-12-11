/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao;

import com.mycompany.dao.OrderDAO;
import com.mycompany.dao.ProductDAO;
import com.mycompany.dao.UserDAO;
import com.mycompany.pojo.Order;
import com.mycompany.pojo.Product;
import com.mycompany.pojo.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.junit.Test;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Fei
 */
public class MainClass {
    
    @Test
    public void productTest() {
        Product product=new Product();
        product.setName("HWatch");
        product.setPrice(22.0);
        product.setReviewCount(30);
        product.setSale(120);
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

    @Test
    public void CreateOrderTest(){
        OrderDAO orderDAO=new OrderDAO();
        Order order=new Order();
        order.setTotal(100.0);
        order.setShippingAddress("a");
        order.setRecipientPhone("12");
        order.setStatus("Pending");
        order.setRecipientName("Tom");
        order.setPaymentMethod("card");
        order.setUserId(1);

        orderDAO.createOrder(order);
    }
}
