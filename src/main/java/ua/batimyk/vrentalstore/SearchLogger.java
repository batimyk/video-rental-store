package ua.batimyk.vrentalstore;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import ua.batimyk.vrentalstore.dao.LoggerDAO;
import ua.batimyk.vrentalstore.model.SearchLog;
import ua.batimyk.vrentalstore.model.SearchResult;

import java.util.Arrays;
import java.util.List;

/**
 * Created by N on 11-Nov-16.
 * video-rental-store-AWS
 */
@Aspect
public class SearchLogger {

    @Autowired
    private LoggerDAO loggerDAO;

    private String userId;

    @AfterReturning(pointcut = "execution(* *.getPrincipal(..))"
                  , returning = "credentials")
    public void getUserId(JoinPoint joinPoint, Object credentials) {

        JSONObject obj = new JSONObject(credentials);
        userId = obj.get("principal").toString();

    }

    @AfterReturning(value = "execution(* ua.batimyk.vrentalstore.dao.SearchFilmDAO.getFilms(..))"
                    ,returning = "searchResult")
    public void afterSearch(JoinPoint joinPoint, List<SearchResult> searchResult) {

         loggerDAO.save(
                new SearchLog(
                        userId,
                        Arrays.deepToString(joinPoint.getArgs()),
                        searchResult.size()
                )
        );

    }

}
