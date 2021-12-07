/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.pojo.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.util.List;

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
            System.out.println("user not saved in the DB");
        }

        System.out.println("user saved in the DB");
    }

    public List<User> displayUserList(){
        try {
            begin();
            List<User> list = getSession().createQuery("from User").list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not get all user" +  e.getMessage());
            return null;
        }
    }

    public User deleteUserById(int id){
        try {
            begin();
            Query q = getSession().createQuery("from User where id = " + id);
            User artist = (User) q.uniqueResult();
            getSession().delete(artist);
            commit();
            return artist;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not delete user: " + id +  e.getMessage());
            return null;
        }
    }

    public void updateUser(User product){
        try {
            begin();
            getSession().update(product);
            commit();
        }
        catch (HibernateException e) {
            rollback();
            System.out.println("Could not update product: " +  e.getMessage());
        }
    }

    public List<User> searchUserListByKeyWord(String s){
        try {
            begin();
            Query query = getSession().createQuery("from User where name like :name");
            String keywords="%"+s+"%";
            query.setString("name",keywords);
            List<User> list = query.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not get products" +  e.getMessage());
            return null;
        }
    }

    public User getUserByName(String s){
        try {
            begin();
            Query query = getSession().createQuery("from User where name=:name");
            query.setString("name",s);
            User product=(User) query.uniqueResult();
            close();
            return product;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not get product" +  e.getMessage());
            return null;
        }
    }

    public User get(String username,String password){
        try {
            begin();
            Query q = getSession().createQuery("from User where name = :username and password = :password");
            q.setString("username", username);
            q.setString("password", password);
            User user = (User) q.uniqueResult();
            close();
            return user;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public User create(String username, String password, String type)  {
        try {
            begin();
            User u = new User();
            u.setName(username);
            u.setPassword(password);
            u.setUserType(type);
//            u.setPlaylistAdded(new ArrayList<Playlist>());

            //check if username is already used
            Query q = getSession().createQuery("From User where name =:username");
            q.setString("username", username);
            List list =q.list();
            if(list.size()>0){
                System.out.println("User already existed");
                return null;
            }
            getSession().save(u);
            commit();
            return u;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not add user  " +  e.getMessage());
            return null;
        }
    }
}
