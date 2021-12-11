package com.mycompany.controller;

import com.mycompany.dao.DAOFactory;
import com.mycompany.dao.OrderDAO;
import com.mycompany.pojo.Order;
import com.mycompany.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

        String pay = request.getParameter("pay");
        String receiver = request.getParameter("receiver");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");
        Object total = session.getAttribute("total");

        Order order=new Order();
        order.setPaymentMethod(pay);
        order.setStatus("Pending");
        order.setRecipientName(receiver);
        order.setRecipientPhone(mobile);
        order.setShippingAddress(address);
        order.setTotal((double)total);

        orderDAO.createOrder(order);
        return "success";
    }

}
