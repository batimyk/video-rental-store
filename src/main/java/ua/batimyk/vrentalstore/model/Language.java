package ua.batimyk.vrentalstore.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by N on 01-Nov-16.
 * video-rental-store
 */

@Entity
@Table(name = "language")
public class Language {

    @Id
    @Column(name = "language_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte languageId;

    @Column(name = "name", columnDefinition="char(20)")
    private String languageName;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public Byte getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Byte languageId) {
        this.languageId = languageId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
