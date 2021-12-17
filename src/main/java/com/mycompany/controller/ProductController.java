package com.mycompany.controller;

import com.mycompany.dao.DAOFactory;
import com.mycompany.dao.ProductDAO;
import com.mycompany.dao.ReviewDAO;
import com.mycompany.pojo.Product;
import com.mycompany.pojo.Review;
import com.mycompany.util.CategoryData;
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
public class ProductController {
    @Autowired
    private DAOFactory factory;

    public ProductController(){

    }
    @RequestMapping(value="/user/products.htm", method = RequestMethod.GET)
    public String displayArtists(HttpServletRequest request){
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
                return "user-productlist";
            }else if("productname".equals(color)){
                List<Product> list = productDAO.searchProductListByKeyWord(id);
                session.setAttribute("productlist",list);
                return "user-productlist";
            }
        }catch (Exception e){
            e.printStackTrace();
            List<Product> list = productDAO.displayProductList();
            session.setAttribute("productlist",list);
            return "user-productlist";
        }

        List<Product> list = productDAO.displayProductList();
        session.setAttribute("productlist",list);
        return "user-productlist";
    }
    @RequestMapping(value="/showProduct.htm", method = RequestMethod.GET)
    public String showProduct(Model model, @RequestParam String product_id) {
//        Product product = productService.get(product_id);
//        productService.setReviewCount(product);
//        model.addAttribute("product", product);
//        List<PropertyValue> propertyValues = propertyValueService.listByProductId(product_id);
//        model.addAttribute("propertyValues", propertyValues);
//        ReviewDAO.
//        model.addAttribute("reviews", reviews);

        ProductDAO productDAO=new ProductDAO();
        Product product = productDAO.getProductByID(Integer.valueOf(product_id));
        model.addAttribute("product",product);

        return "product";
    }


}
