package com.flashcards.demo.dao;

import com.flashcards.demo.entity.FlashCards;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class FlashCardsDAOimpl implements FlashCardsDAO {

    //Define field for entity manager
    /* The EntityManager API is used to create and remove persistent entity to find entities by their primary key, and query over entities.*/
    private EntityManager entityManager;

    //Set up constructor injection
    @Autowired
    public FlashCardsDAOimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public List<FlashCards> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<FlashCards> myQuery = currentSession.createQuery("from FlashCards ");
        List<FlashCards> flashcards = myQuery.getResultList();
        return flashcards;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public FlashCards findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        FlashCards flashcards= currentSession.get(FlashCards.class, id);
        return flashcards;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void save( FlashCards flashcards) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(flashcards);

    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<FlashCards> theQuery = currentSession.createQuery("delete from FlashCards where id =:id");
        theQuery.setParameter("id", id);
        theQuery.executeUpdate();
    }


}
