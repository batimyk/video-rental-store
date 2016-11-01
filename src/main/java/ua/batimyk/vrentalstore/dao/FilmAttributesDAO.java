package ua.batimyk.vrentalstore.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.batimyk.vrentalstore.model.*;

import java.util.List;

/**
 * Created by N on 01-Nov-16.
 * video-rental-store
 */
@Repository
@Transactional
public class FilmAttributesDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<Category> getCategories() {
        return (List<Category>) getSession().createQuery("from Category").list();
    }

    @SuppressWarnings("unchecked")
    public List<Language> getLanguages() {
        return (List<Language>) getSession().createQuery("from Language").list();
    }

    @SuppressWarnings("unchecked")
    public List<Actor> getActors() {
        return (List<Actor>) getSession().createQuery("from Actor").list();
    }
}
