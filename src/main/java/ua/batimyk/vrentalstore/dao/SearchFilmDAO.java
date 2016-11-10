package ua.batimyk.vrentalstore.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.batimyk.vrentalstore.model.SearchCriteria;
import ua.batimyk.vrentalstore.model.SearchResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by N on 09-Nov-16.
 * video-rental-store-AWS
 */
@Repository
@Transactional
public class SearchFilmDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<SearchResult> getFilms(SearchCriteria searchCriteria) {
        List<SearchResult> searchResults = new ArrayList<>();

        List<Object[]> listResult = getSession().createSQLQuery(
                "SELECT \n" +
                        "    f.title,\n" +
                        "    f.description,\n" +
                        "    c.name categoryName,\n" +
                        "    f.release_year releaseYear,\n" +
                        "    l.name languageName,\n" +
                        "    f.length filmLength,\n" +
                        "    f.rating,\n" +
                        "    GROUP_CONCAT(DISTINCT CONCAT(a.first_name, ' ', a.last_name)\n" +
                        "        SEPARATOR ', ') actorNames\n" +
                        "FROM\n" +
                        "    film f\n" +
                        "        JOIN\n" +
                        "    film_category fc ON fc.film_id = f.film_id\n" +
                        "        JOIN\n" +
                        "    category c ON c.category_id = fc.category_id\n" +
                        "        JOIN\n" +
                        "    language l ON l.language_id = f.language_id\n" +
                        "        LEFT JOIN\n" +
                        "    film_actor fa ON fa.film_id = f.film_id\n" +
                        "        LEFT JOIN\n" +
                        "    actor a ON fa.actor_id = a.actor_id\n" +
                        "        JOIN\n" +
                        "    (SELECT \n" +
                        "            COALESCE(:title,'') AS title,\n" +
                        "            COALESCE(:description,'') AS description,\n" +
                        "            COALESCE(:category,'') AS category,\n" +
                        "            COALESCE(:languageName,'') AS languageName,\n" +
                        "            COALESCE(:actor,'') AS actor\n" +
                        "    FROM DUAL) st ON (f.title LIKE CONCAT('%', st.title, '%')\n" +
                        "        AND f.description LIKE CONCAT('%', st.description, '%')\n" +
                        "        AND c.name LIKE CONCAT('%', st.category, '%')\n" +
                        "        AND l.name LIKE CONCAT('%', st.languageName, '%')\n" +
                        "        AND (a.first_name LIKE CONCAT('%', st.actor, '%')\n" +
                        "        OR a.last_name LIKE CONCAT('%', st.actor, '%')\n" +
                        "        OR st.actor LIKE CONCAT(a.last_name, '%', a.first_name)\n" +
                        "        OR st.actor LIKE CONCAT(a.first_name, '%', a.last_name)))\n" +
                        "GROUP BY f.title , f.description , c.name , f.release_year , l.name , f.length , f.rating")
                .setParameter("title", searchCriteria.getFilmTitle())
                .setParameter("description", searchCriteria.getFilmDescription())
                .setParameter("category", searchCriteria.getFilmCategory())
                .setParameter("languageName", searchCriteria.getLanguageName())
                .setParameter("actor", searchCriteria.getActorName())
                .list();

        for (Object[] row : listResult) {
            searchResults.add(new SearchResult(row));
        }
        return searchResults;
    }
}
