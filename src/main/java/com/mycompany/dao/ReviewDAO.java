package com.mycompany.dao;

import com.mycompany.pojo.Review;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.util.List;

public class ReviewDAO extends DAO{
    public void createReview(Review user) {
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

    public List<Review> displayReviewList(){
        try {
            begin();
            List<Review> list = getSession().createQuery("from Review").list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not get all user" +  e.getMessage());
            return null;
        }
    }

    public Review deleteReviewById(int id){
        try {
            begin();
            Query q = getSession().createQuery("from Review where id = " + id);
            Review artist = (Review) q.uniqueResult();
            getSession().delete(artist);
            commit();
            return artist;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not delete user: " + id +  e.getMessage());
            return null;
        }
    }

    public void updateReview(Review product){
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

    public List<Review> searchReviewListByKeyWord(String s){
        try {
            begin();
            Query query = getSession().createQuery("from Review where comment like :name");
            String keywords="%"+s+"%";
            query.setString("name",keywords);
            List<Review> list = query.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            System.out.println("Could not get products" +  e.getMessage());
            return null;
        }
    }


}
