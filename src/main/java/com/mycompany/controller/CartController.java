package com.mycompany.controller;

import com.mycompany.dao.DAOFactory;
import com.mycompany.dao.ProductDAO;
import com.mycompany.pojo.CartItem;
import com.mycompany.pojo.Product;
import com.mycompany.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private DAOFactory factory;

    public CartController() {

    }
    @RequestMapping(value = "/user/cart.htm", method = RequestMethod.GET)
    public String showAllCartlist(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession(false);
            User u = (User) session.getAttribute("currentUser");
//        session.setAttribute("currentlist", );
            return "cart";
        }catch (Exception e){
            return "cart_error";
        }

    }

    @RequestMapping(value = "/user/addCart.htm", method = RequestMethod.GET)
    public String addCart(HttpServletRequest request,HttpSession session) {
        int product_id=Integer.valueOf(request.getParameter("product_id"));
        int number=Integer.valueOf(request.getParameter("number"));
        ProductDAO productDAO=new ProductDAO();
        Product product = productDAO.getProductByID(Integer.valueOf(product_id));
//        productDAO.updateProduct();
        double total=0;

        try {
            User user = (User) session.getAttribute("currentUser");
            String cartId = "cart";
            List<CartItem> list=null;
            try {
                Object attribute = session.getAttribute(cartId);
                list = (List<CartItem>) attribute;
                updateCartItem(list,product,number);
                for (CartItem cartItem : list) {
                    total+=cartItem.getSubtotal();
                }
                session.setAttribute(cartId, list);
                session.setAttribute("total", total);
            }catch (Exception e){
                list = new ArrayList<>();
                CartItem cartItem=new CartItem();
                cartItem.setNumber(number);
                cartItem.setProduct(product);
                list.add(cartItem);
                for (CartItem cart : list) {
                    total+=cart.getSubtotal();
                }
                session.setAttribute(cartId, list);
                session.setAttribute("total", total);
            }
            return "cart";
        }catch (Exception e){
            e.printStackTrace();
            return "cart_error";
        }
    }
    @RequestMapping(value = "/user/deleteCart.htm", method = RequestMethod.GET)
    public String deleteCart(HttpServletRequest request,HttpSession session) {
        int product_id = Integer.valueOf(request.getParameter("product_id"));
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getProductByID(Integer.valueOf(product_id));
        double total=0;
//        productDAO.updateProduct();
        try {
            User user = (User) session.getAttribute("currentUser");
            String cartId = "cart";
            List<CartItem> list = null;
                Object attribute = session.getAttribute(cartId);
                list = (List<CartItem>) attribute;
                for (CartItem cartItem : list) {
                    if (cartItem.getProduct().equals(product)) {
                        list.remove(cartItem);
                    }
                }
            for (CartItem cartItem : list) {
                total+=cartItem.getSubtotal();
            }
                session.setAttribute(cartId, list);
                session.setAttribute("total", total);
                return "cart";
            } catch (Exception e) {
                e.printStackTrace();
                return "cart";
            }
        }


    public void updateCartItem(List<CartItem> list,Product product,int number){
        for(CartItem cartItem: list){
            if (cartItem.getProduct().equals(product)){
                number+=cartItem.getNumber();
                cartItem.setNumber(number);
                return;
            }
        }
        CartItem cartItem=new CartItem();
        cartItem.setNumber(number);
        cartItem.setProduct(product);
        list.add(cartItem);
    }
    @RequestMapping(value = "/user/checkout.htm", method = RequestMethod.GET)
    public String checkoutCart(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession(false);
            User u = (User) session.getAttribute("currentUser");
            return "checkout";
        }catch (Exception e){
            return "cart_error";
        }

    }


//    @RequestMapping(value = "/user/addCart.htm", method = RequestMethod.GET)
//    public String addCart(@RequestParam int product_id,HttpServletRequest request,HttpSession session) {
//        ProductDAO productDAO=new ProductDAO();
//        Product product = productDAO.getProductByID(Integer.valueOf(product_id));
//        User user = (User) session.getAttribute("currentuser");
//        boolean found = false;
//        String cartId = "cart"+user.getId();
//        List<Product> list;
//        Object attribute = session.getAttribute(cartId);
//        if (attribute!=null){
//            list= (List<Product>)attribute;
//            list.add(product);
//            session.setAttribute(cartId,list);
//        }else{
//            list=new ArrayList<>();
//            list.add(product);
//        }
//        return "user-addcartsuccess";
//    }

//    @RequestMapping(value = "/addCart.htm",method = RequestMethod.GET)
//    @ResponseBody
//    public String addCart(@RequestParam int product_id,@RequestParam int num, Model model, HttpSession session) {
//        ProductDAO productDAO=new ProductDAO();
//        Product product = productDAO.getProductByID(Integer.valueOf(product_id));
//        User user = (User) session.getAttribute("currentuser");
//        boolean found = false;
//        String cartId = "cart"+user.getId();
//        List<Product> list;
//        Object attribute = session.getAttribute(cartId);
//        if (attribute!=null){
//            list= (List<Product>)attribute;
//            list.add(product);
//            session.setAttribute(cartId,list);
//        }else{
//            list=new ArrayList<>();
//            list.add(product);
//        }
//        return "success";
//    }
}
