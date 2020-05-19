package com.flashcards.demo.dao;

import com.flashcards.demo.entity.Login;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class LoginDAOimpl implements LoginDAO {


    //Define field for entity manager
    /* The EntityManager API is used to create and remove persistent entity to find entities by their primary key, and query over entities.*/
    private EntityManager entityManager;

    //Set up constructor injection
    @Autowired
    public LoginDAOimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public List<Login> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Login> myQuery1 = currentSession.createQuery("from login");
        List<Login> login = myQuery1.getResultList();
        return login;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public Login findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Login login= currentSession.get(Login.class, id);
        return login;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void save( Login login) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(login);

    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Login> theQuery2 = currentSession.createQuery("delete from login where id =:id");
        theQuery2.setParameter("id", id);
        theQuery2.executeUpdate();
    }
}
