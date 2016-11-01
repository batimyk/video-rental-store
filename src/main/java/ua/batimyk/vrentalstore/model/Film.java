package ua.batimyk.vrentalstore.model;

import org.hibernate.annotations.Type;
import javax.persistence.*;

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

}
