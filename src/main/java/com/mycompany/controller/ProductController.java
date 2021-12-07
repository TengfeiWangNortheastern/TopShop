package com.mycompany.controller;

import com.mycompany.dao.DAOFactory;
import com.mycompany.dao.ProductDAO;
import com.mycompany.dao.ReviewDAO;
import com.mycompany.pojo.Product;
import com.mycompany.pojo.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private DAOFactory factory;

    public ProductController(){

    }
    @RequestMapping(value="/user/products.htm", method = RequestMethod.GET)
    public String displayArtists(HttpServletRequest request){
        ProductDAO mdao = factory.createProductDAO();
        List<Product> productList = mdao.displayProductList();
        HttpSession session = request.getSession();
        session.setAttribute("productlist", productList);
        return "user-productlist";
    }
    @RequestMapping(value="/showProduct.htm", method = RequestMethod.GET)
    public String showProduct(Model model,HttpServletRequest request) {
//        Product product = productService.get(product_id);
//        productService.setReviewCount(product);
//        model.addAttribute("product", product);
//        List<PropertyValue> propertyValues = propertyValueService.listByProductId(product_id);
//        model.addAttribute("propertyValues", propertyValues);
//        ReviewDAO.
//        model.addAttribute("reviews", reviews);
//        ProductDAO pdao = factory.createProductDAO();
//        pdao.displayProductList()
        int product_id = Integer.valueOf(request.getParameter("product_id"));
        ProductDAO productDAO=new ProductDAO();
        Product product = productDAO.getProductByID(product_id);
//        if(product==null) return "error";
        model.addAttribute("product", product);
        return "product";
    }
}