package com.mycompany.controller;

import com.mycompany.dao.DAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserAjaxController {

    @Autowired
    private DAOFactory factory;

    public UserAjaxController(){

    }
//
//    @RequestMapping(value = "service.htm",method = RequestMethod.GET)
//    public ModelAndView handleRequest(HttpServletRequest request){
//        String username=request.getParameter("username");
//        String password=request.getParameter("password");
//
//        UserDAO userDAO = factory.createUserDAO();
//
//
//        String result = "";
//        if(u==null){
//            result = result + "invalid username and password!!";
//        }
//
//        return result;
//    }
}
