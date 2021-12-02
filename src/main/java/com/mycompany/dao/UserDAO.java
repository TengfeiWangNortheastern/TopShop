/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.pojo.User;

/**
 *
 * @author Fei
 */
public class UserDAO extends DAO{
    public void createUser(User user) {
        try {
            begin();
            getSession().save(user);
            commit();
        } catch (Exception e) {
            rollback();
        }

        System.out.println("user saved in the DB");
    }
}
