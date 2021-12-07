/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dao.DAOFactory;
import com.mycompany.dao.UserDAO;
import com.mycompany.pojo.User;
import com.mycompany.util.SysData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fei
 */
@Controller
public class UserController {
    @Autowired
    private DAOFactory factory;

    public UserController(){
    }

    //display admin error form
    @RequestMapping(value="/error.htm")
    public String showError(HttpServletRequest request){
        return "error";
    }

    //display admin login form
    @RequestMapping(value="/user/login.htm", method = RequestMethod.GET)
    public String showLogin(HttpServletRequest request){
        return "LoginPage";
    }

    @RequestMapping(value = "/user/login.htm", method = RequestMethod.POST)
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
            System.out.println("Could not login user "  +  e.getMessage());
        }
        return "LoginPage";
    }

    @RequestMapping(value = "/user/logout.htm", method = RequestMethod.GET)
    public String logoutUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
        }
        return "LoginPage";
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
}
