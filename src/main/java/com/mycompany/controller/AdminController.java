package com.mycompany.controller;

import com.mycompany.dao.DAOFactory;
import com.mycompany.dao.OrderDAO;
import com.mycompany.dao.ProductDAO;
import com.mycompany.dao.UserDAO;
import com.mycompany.pojo.Orderitem;
import com.mycompany.pojo.Orders;
import com.mycompany.pojo.Product;
import com.mycompany.pojo.User;
import com.mycompany.util.SysData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
//
//        List<Orderitem> orderitemList=orderDAO.getOrderItemsByOrderId(order.getId());
//        model.addAttribute("orderitems",orderitemList);
        return "admin-order-edit";
    }
    @RequestMapping(value = "/admin/updateOrder.htm", method = RequestMethod.POST)
    public String updateAdminOrder(HttpServletRequest request,@RequestParam String order_id,Model model) {

        OrderDAO orderDAO=factory.createOrderDAO();
        String pay = request.getParameter("payment");
        String receiver = request.getParameter("receiver_name");
        String mobile = request.getParameter("phone");
        String address = request.getParameter("address");
        String status = request.getParameter("status");
//        Double total = (double)request.getAttribute("total");
//
        Orders order=orderDAO.getOrdersById(Integer.valueOf(order_id));
        order.setPayment(pay);
        order.setRecipientName(receiver);
        order.setRecipientPhone(mobile);
        order.setShippingAddress(address);
        order.setStatus(status);
        orderDAO.updateOrder(order);
        model.addAttribute("order",order);
        return "admin-order-edit";
//        return "success";
    }
    @RequestMapping(value = "/admin/deleteOrder.htm")
    public String deleteAdminOrder(HttpServletRequest request,@RequestParam String order_id) {

        OrderDAO orderDAO=factory.createOrderDAO();
        Orders order=orderDAO.getOrdersById(Integer.valueOf(order_id));
        orderDAO.deleteOrder(order);

        HttpSession session = request.getSession();
        List<Orders> ordersByUserId = orderDAO.getAllOrders();
        session.setAttribute("adminorders",ordersByUserId);
        return "admin-orders";
//        return "success";
    }
    @RequestMapping(value = "/admin/showProduct.htm")
    public String showProduct(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ProductDAO productDAO=factory.createProductDAO();
        try{
            String color = request.getParameter("color");
            String id = request.getParameter("search");
            if("productid".equals(color)) {
                Product product= productDAO.getProductByID(Integer.valueOf(id));
                List<Product> list=new ArrayList<>();
                if(product!=null)list.add(product);
                session.setAttribute("productlist",list);
                return "admin-products";
            }else if("productname".equals(color)){
                List<Product> list = productDAO.searchProductListByKeyWord(id);
                session.setAttribute("productlist",list);
                return "admin-products";
            }
        }catch (Exception e){
            e.printStackTrace();
            List<Product> list = productDAO.displayProductList();
            session.setAttribute("productlist",list);
            return "admin-products";
        }

        List<Product> list = productDAO.displayProductList();
        session.setAttribute("productlist",list);
        return "admin-products";
    }
    @RequestMapping(value = "/admin/showUsers.htm")
    public String showAdminUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserDAO userDAO = factory.createUserDAO();
        try{
            String color = request.getParameter("color");
            String id = request.getParameter("search");
            if("productid".equals(color)) {
                User userById = userDAO.getUserById(Integer.valueOf(id));
                List<User> list=new ArrayList<>();
                if(userById!=null)list.add(userById);
                session.setAttribute("userlist",list);
                return "admin-users";
            }else if("productname".equals(color)){
                List<User> list = userDAO.searchUserListByKeyWord(id);
                session.setAttribute("userlist",list);
                return "admin-users";
            }
        }catch (Exception e){
            e.printStackTrace();
            List<User> list = userDAO.displayUserList();
            session.setAttribute("userlist",list);
            return "admin-users";
        }

        List<User> list = userDAO.displayUserList();
        session.setAttribute("productlist",list);
        return "admin-users";
    }
}
