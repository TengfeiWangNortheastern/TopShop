package com.mycompany.controller;

import com.mycompany.dao.DAOFactory;
import com.mycompany.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CartController {
    @Autowired
    private DAOFactory factory;

    public CartController() {

    }
    @RequestMapping(value = "/user/cart.htm", method = RequestMethod.GET)
    public String showAllCartlist(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        User u = (User) session.getAttribute("currentuser");

//        session.setAttribute("currentlist", );
        return "user-playlist";
    }
}
