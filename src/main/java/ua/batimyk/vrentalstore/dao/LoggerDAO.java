package ua.batimyk.vrentalstore.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.batimyk.vrentalstore.model.SearchLog;

/**
 * Created by N on 14-Nov-16.
 * video-rental-store-AWS
 */
@Repository
@Transactional
public class LoggerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(SearchLog searchLogItem) {
        getSession().save(searchLogItem);
    }
}
