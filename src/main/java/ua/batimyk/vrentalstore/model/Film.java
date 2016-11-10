package ua.batimyk.vrentalstore.model;

import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "film")
public class Film{

    @Id
    @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short filmId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    @Type(type="text")
    private String description;

    @Column(name = "release_year")
    private Date releaseYear;

    @Column(name = "length")
    private Short filmLength;

    @Column(name = "rating",  columnDefinition="enum('G','PG','PG-13','R','NC-17')")
    private String rating;

    public Film() {
    }

    public Film(Short filmId, String title, String description) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
    }

    public Short getFilmId() {
        return filmId;
    }

    public void setFilmId(Short filmId) {
        this.filmId = filmId;
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

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
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
}
