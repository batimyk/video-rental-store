package ua.batimyk.vrentalstore.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "film_category")
public class FilmCategory {

    @Id
    @Column(name = "film_id")
    private Short filmId;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @Column(name = "category_id")
    private Byte categoryId;


    public Short getFilmId() {
        return filmId;
    }

    public void setFilmId(Short filmId) {
        this.filmId = filmId;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Byte getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Byte categoryId) {
        this.categoryId = categoryId;
    }

}
