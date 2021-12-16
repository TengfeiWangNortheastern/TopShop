package com.mycompany.controller;

import com.mycompany.dao.DAOFactory;
import com.mycompany.dao.OrderDAO;
import com.mycompany.pojo.CartItem;
import com.mycompany.pojo.Orderitem;
import com.mycompany.pojo.Orders;
import com.mycompany.pojo.User;
import com.mycompany.util.SysData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private DAOFactory factory;

    public OrderController() {
    }

    @RequestMapping(value = "/createOrder.htm", method = RequestMethod.POST)
    public String createOrderUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        User u = (User) session.getAttribute("currentUser");
        OrderDAO orderDAO=factory.createOrderDAO();
        List<CartItem> list=(List<CartItem>)session.getAttribute("cart");
        String pay = request.getParameter("pay");
        String receiver = request.getParameter("receiver");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");
        String status= SysData.PENDING.toString();
        Object total = session.getAttribute("total");

        Orders order=new Orders();

        order.setOrderitems(new ArrayList<Orderitem>());
        order.setTotal((double) total);
        order.setShippingAddress(address);
        order.setRecipientPhone(mobile);
        order.setStatus(status);
        order.setRecipientName(receiver);
        order.setPayment(pay);
        order.setUserId(u.getId());
        order.setTime(new Timestamp(System.currentTimeMillis()));


        for (CartItem cartItem:list){
            Orderitem orderitem=new Orderitem();
            orderitem.setProductId(cartItem.getProduct().getId());
            orderitem.setSubtotal(cartItem.getSubtotal());
            orderitem.setOrder(order);
            order.getOrderitems().add(orderitem);
        }
        orderDAO.createOrder(order);
        return "orderconfirm";
    }

    @RequestMapping(value = "/user/showOrder.htm", method = RequestMethod.POST)
    public String showUserOrder(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        User u = (User) session.getAttribute("currentUser");
        OrderDAO orderDAO=factory.createOrderDAO();
        List<Orders> ordersByUserId = orderDAO.getOrdersByUserId(u.getId());
        session.setAttribute("orders",ordersByUserId);
        return "user-order";
    }
    

}
