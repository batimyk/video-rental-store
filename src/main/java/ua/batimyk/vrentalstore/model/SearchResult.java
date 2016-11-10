package ua.batimyk.vrentalstore.model;

import java.sql.Date;

/**
 * Created by N on 10-Nov-16.
 * video-rental-store-AWS
 */

public class SearchResult {

    private String title;

    private String description;

    private String categoryName;

    private Date releaseYear;

    private String languageName;

    private Short filmLength;

    private String rating;

    private String actorNames;

    public SearchResult() {
    }

    public<T> SearchResult(T[] attr) {
        this.title = (String) attr[0];
        this.description = (String) attr[1];
        this.categoryName = (String) attr[2];
        this.releaseYear = (Date) attr[3];
        this.languageName = (String) attr[4];
        this.filmLength = (Short) attr[5];
        this.rating = (String) attr[6];
        this.actorNames = (String) attr[7];
    }

    public SearchResult(String title
            , String description
            , String categoryName
            , Date releaseYear
            , String languageName
            , Short filmLength
            , String rating
            , String actorNames) {
        this.title = title;
        this.description = description;
        this.categoryName = categoryName;
        this.releaseYear = releaseYear;
        this.languageName = languageName;
        this.filmLength = filmLength;
        this.rating = rating;
        this.actorNames = actorNames;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public Short getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(Short filmLength) {
        this.filmLength = filmLength;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getActorNames() {
        return actorNames;
    }

    public void setActorNames(String actorNames) {
        this.actorNames = actorNames;
    }
}
