package com.mycompany.dao;

public class DAOFactory {
    public UserDAO createUserDAO(){
        return new UserDAO();
    }
    public ProductDAO createProductDAO(){
        return new ProductDAO();
    }
    public ReviewDAO createReviewDAO(){
        return new ReviewDAO();
    }
    public OrderDAO createOrderDAO(){
        return new OrderDAO();
    }
}
