/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao;

import com.mycompany.dao.DAOFactory;
import com.mycompany.dao.OrderDAO;
import com.mycompany.dao.ProductDAO;
import com.mycompany.dao.UserDAO;
import com.mycompany.pojo.Orderitem;
import com.mycompany.pojo.Orders;
import com.mycompany.pojo.Product;
import com.mycompany.pojo.User;
import com.mycompany.util.CategoryData;
import com.mycompany.util.SysData;
import org.hibernate.Criteria;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fei
 */
public class MainClass {
    
    @Test
    public void productTest() {
        Product product=new Product();
        product.setName("Harry Potter");
        product.setPrice(20);
        product.setReviewCount(20);
        product.setSale(60);
        product.setStock(400);
        product.setSubTitle(CategoryData.BOOK.toString());
        ProductDAO productDAO=new ProductDAO();
        productDAO.createProduct(product);
    }
    @Test
    public void productTest2() {
        Product product=new Product();
        product.setName("The North Face");
        product.setPrice(200);
        product.setReviewCount(12);
        product.setSale(60);
        product.setStock(400);
        product.setSubTitle(CategoryData.CLOTHES.toString());
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
        user.setUserType(SysData.ADMIN.toString());
        UserDAO userDAO=new UserDAO();
        userDAO.createUser(user);
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
        Orders order=new Orders();
        order.setTotal((double) 100.0);
        order.setShippingAddress("aaaaa");
        order.setRecipientPhone("12334");
        order.setStatus("Pending");
        order.setRecipientName("Tom");
        order.setPayment("Card");
        order.setUserId(1);
        order.setTime(new Timestamp(System.currentTimeMillis()));
        orderDAO.createOrder(order);
    }
    @Test
    public void manyTest(){
        Orderitem o=new Orderitem();
        Orders order=new Orders();
        order.setTotal((double) 100.0);
        order.setShippingAddress("aaaaa");
        order.setRecipientPhone("12334");
        order.setStatus("Pending");
        order.setRecipientName("Tom");
        order.setPayment("Card");
        order.setUserId(1);
        order.setTime(new Timestamp(System.currentTimeMillis()));
        order.setOrderitems(new ArrayList<Orderitem>());
        o.setOrder(order);
        o.setProductId(1);
        o.setSubtotal(100.0);

        order.getOrderitems().add(o);

        OrderDAO orderDAO=new OrderDAO();
        orderDAO.createOrder(order);
    }

    @Test
    public void getOrderTest(){
        int id=1;
        OrderDAO orderDAO= new DAOFactory().createOrderDAO();
        Orders ordersById = orderDAO.getOrdersById(1);
        System.out.println(ordersById.getTotal());
        List<Orderitem> orderitems = ordersById.getOrderitems();
        System.out.println(orderitems.size());
    }
    @Test
    public void getOrders(){
        int id=1;
        OrderDAO orderDAO= new DAOFactory().createOrderDAO();
        List<Orders> allOrders = orderDAO.getAllOrders();
        System.out.println(allOrders.size());
    }
    @Test
    public void getOrdersstatus(){
        String status=SysData.PENDING.toString();
        OrderDAO orderDAO= new DAOFactory().createOrderDAO();
        List<Orders> allOrders = orderDAO.getAllOrders(status);
        System.out.println(allOrders.size());
    }
    @Test
    public void getOrdersByOrderId(){
        OrderDAO orderDAO= new DAOFactory().createOrderDAO();
        Orders ordersById = orderDAO.getOrdersById(1);
        List<Orderitem> orderItemsByOrderId = orderDAO.getOrderItemsByOrderId(ordersById);
        System.out.println(orderItemsByOrderId.size());
    }

    @Test
    public void updateOrder(){
        OrderDAO orderDAO=new OrderDAO();
        Orders order=orderDAO.getOrdersById(5);
        order.setPayment("cash");
        order.setRecipientName("receiver");
        order.setRecipientPhone("8572655561");
        order.setShippingAddress("address");
        orderDAO.updateOrder(order);
    }
}
