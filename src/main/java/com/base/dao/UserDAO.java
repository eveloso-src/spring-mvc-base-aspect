package com.base.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.base.model.User;

@Repository
public class UserDAO
//implements UserDao 
{

   @Autowired
   private SessionFactory sessionFactory;

//   @Override
//   public void add(User user) {
//      sessionFactory.getCurrentSession().save(user);
//   }
//
//   @Override
//   public List<User> listUsers() {
//      @SuppressWarnings("unchecked")
//      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
//      return query.getResultList();
//   }

}