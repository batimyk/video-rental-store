package ua.batimyk.vrentalstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.batimyk.vrentalstore.dao.FilmAttributesDAO;
import ua.batimyk.vrentalstore.dao.SearchFilmDAO;
import ua.batimyk.vrentalstore.model.Category;
import ua.batimyk.vrentalstore.model.SearchCriteria;
import ua.batimyk.vrentalstore.model.SearchResult;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by N on 09-Nov-16.
 * video-rental-store-AWS
 */
@RestController
public class SearchFilmController {

    private SearchFilmDAO searchFilmDAO;

    public SearchFilmController(@Autowired SearchFilmDAO searchFilmDAO) {
        this.searchFilmDAO = searchFilmDAO;
    }

    @RequestMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<List<SearchResult>> searchFilms(@RequestBody SearchCriteria searchCriteria) {

        List<SearchResult> responseData = searchFilmDAO.getFilms(searchCriteria);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
