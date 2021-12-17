/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dao.DAOFactory;
import com.mycompany.dao.OrderDAO;
import com.mycompany.dao.ProductDAO;
import com.mycompany.dao.UserDAO;
import com.mycompany.pojo.Orders;
import com.mycompany.pojo.Product;
import com.mycompany.pojo.User;
import com.mycompany.util.SysData;
import com.mycompany.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fei
 */
@Controller
public class UserController {
    @Autowired
    private DAOFactory factory;

    @Autowired
    private UserValidator userValidator;

    public UserController(){
    }

    //display admin error form
    @RequestMapping(value="/error.htm")
    public String showError(HttpServletRequest request){
        return "error";
    }

//    //display admin login form
//    @RequestMapping(value="/user/login.htm", method = RequestMethod.GET)
//    public String showLogin(HttpServletRequest request){
//        return "LoginPage";
//    }

    @RequestMapping(value = "/user/login.htm")
    public String handleLoginForm(HttpServletRequest request,  ModelMap map) {

        UserDAO userdao = factory.createUserDAO();

        HttpSession session = request.getSession(true);

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username + " " + password);

        try {
            User u = userdao.get(username, password);
            if (u != null) {
                session.setAttribute("currentUser", u);
                if (u.getUserType().equals(String.valueOf(SysData.ADMIN))) return "admin-index";

                return "user-dashboard";
            }
        }
        catch (Exception e) {
            return "error";
        }
        return "LoginPage";
    }

    @RequestMapping(value = "/user/logout.htm", method = RequestMethod.GET)
    public String logoutUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
        }
        return "LogOut";
    }

    @RequestMapping(value = "/user/register.htm", method = RequestMethod.GET)
    public String getCreateUserForm(HttpServletRequest request){
        return "register";
    }

    @RequestMapping(value = "/user/register.htm", method = RequestMethod.POST)
    public String handelCreateUserForm(HttpServletRequest request){
        HttpSession session = request.getSession(true);

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirm_password=request.getParameter("password-confirm");
        if(!password.equals(confirm_password))
            return "register";
        String userType= request.getParameter("accountType");
        System.out.println(username + " " + password+" "+userType);
        if ("customer".equals(userType)){
            userType= String.valueOf(SysData.CUSTOMER);
        }else{
            userType=String.valueOf(SysData.ADMIN);
        }
        UserDAO userdao = factory.createUserDAO();
        User user = userdao.create(username,password,userType);

        if(user!=null){
            return "success";
        }
        return "register";
    }


    @RequestMapping(value = "/user/delete.htm", method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest request) {
        return "LoginPage";
    }


    @RequestMapping(value = "/user/showOrders.htm")
    public String showAdminUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");
        OrderDAO orderDAO=factory.createOrderDAO();
        List<Orders> ordersByUserId = orderDAO.getOrdersByUserId(user.getId());
        session.setAttribute("adminorders",ordersByUserId);
        return "user-order";
    }
    @RequestMapping(value = "/user/changeStatusAccept.htm")
    public String acceptUserOrder(HttpServletRequest request,Model model, @RequestParam String order_id) {
        OrderDAO orderDAO = factory.createOrderDAO();
        HttpSession session = request.getSession();
        Orders ordersById = orderDAO.getOrdersById(Integer.valueOf(order_id));
        ordersById.setStatus(SysData.ACCEPTED.toString());
        User user = (User) session.getAttribute("currentUser");
        List<Orders> ordersByUserId = orderDAO.getOrdersByUserId(user.getId());
        session.setAttribute("adminorders",ordersByUserId);
        return "user-order";
    }
    @RequestMapping(value = "/user/changeStatusCancel.htm")
    public String cancelUserOrder(HttpServletRequest request,Model model, @RequestParam String order_id) {
        OrderDAO orderDAO = factory.createOrderDAO();
        HttpSession session = request.getSession();
        Orders ordersById = orderDAO.getOrdersById(Integer.valueOf(order_id));
        ordersById.setStatus(SysData.CANCELED.toString());
        User user = (User) session.getAttribute("currentUser");
        List<Orders> ordersByUserId = orderDAO.getOrdersByUserId(user.getId());
        session.setAttribute("adminorders",ordersByUserId);
        return "user-order";
    }
}
