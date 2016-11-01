package ua.batimyk.vrentalstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.batimyk.vrentalstore.model.*;
import ua.batimyk.vrentalstore.dao.FilmAttributesDAO;

import java.util.List;

/**
 * Created by N on 31-Oct-16.
 * video-rental-store
 */
@RestController
@RequestMapping("/list")
public class FilmAttributesController {

    private FilmAttributesDAO filmAttributesDAO;

    public FilmAttributesController(@Autowired FilmAttributesDAO filmAttributesDAO) {
        this.filmAttributesDAO = filmAttributesDAO;
    }

    @RequestMapping(value = "/get/categories", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = filmAttributesDAO.getCategories();

        if (categories.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "/get/languages", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<Language>> getLanguages() {
        List<Language> languages = filmAttributesDAO.getLanguages();

        if (languages.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(languages, HttpStatus.OK);
    }

    @RequestMapping(value = "/get/actors", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<Actor>> getActors() {
        List<Actor> actors = filmAttributesDAO.getActors();

        if (actors.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }

}
