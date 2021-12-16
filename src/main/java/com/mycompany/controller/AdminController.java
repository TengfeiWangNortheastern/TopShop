package com.mycompany.controller;

import com.mycompany.dao.DAOFactory;
import com.mycompany.dao.OrderDAO;
import com.mycompany.dao.ProductDAO;
import com.mycompany.dao.UserDAO;
import com.mycompany.pojo.Orders;
import com.mycompany.pojo.Product;
import com.mycompany.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private DAOFactory factory;

    public AdminController() {

    }

    //display admin central dashboard
    @RequestMapping(value = "/admin/index.htm", method = RequestMethod.GET)
    public String showDashboard(HttpServletRequest request) {
        return "admin-index";
    }


    //display all user accounts
    @RequestMapping(value = "/admin/user.htm", method = RequestMethod.GET)
    public String manageUserAccount(HttpServletRequest request) {
        UserDAO udao = factory.createUserDAO();
        List<User> userlist = udao.displayUserList();
        HttpSession session = request.getSession();
        session.setAttribute("userlist", userlist);
        return "admin-users";
    }

    //log out admin
    @RequestMapping(value = "/admin/logout.htm")
    public String logoutAdmin(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "LoginPage";
    }

    @RequestMapping(value = "/admin/showOrder.htm")
    public String showUserOrder(HttpServletRequest request) {
        HttpSession session = request.getSession();
        OrderDAO orderDAO=factory.createOrderDAO();
        List<Orders> ordersByUserId = orderDAO.getAllOrders();
        session.setAttribute("adminorders",ordersByUserId);
        return "admin-orders";
    }
    @RequestMapping(value = "/admin/showSelectedOrder.htm")
    public String showProduct(Model model, @RequestParam String order_id) {

        OrderDAO orderDAO=new OrderDAO();
        Orders order=orderDAO.getOrdersById(Integer.valueOf(order_id));
        model.addAttribute("order",order);
        return "admin-order-edit";
    }
}
