package ua.batimyk.vrentalstore.model;

/**
 * Created by N on 09-Nov-16.
 * video-rental-store-AWS
 */

public class SearchCriteria {

    private String filmTitle;
    private String filmDescription;
    private String filmCategory;
    private String actorName;
    private String languageName;

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public String getFilmDescription() {
        return filmDescription;
    }

    public void setFilmDescription(String filmDescription) {
        this.filmDescription = filmDescription;
    }

    public String getFilmCategory() {
        return filmCategory;
    }

    public void setFilmCategory(String filmCategory) {
        this.filmCategory = filmCategory;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    @Override
    public String toString() {
        return
                "filmTitle='" + filmTitle + '\'' +
                ", filmDescription='" + filmDescription + '\'' +
                ", filmCategory='" + filmCategory + '\'' +
                ", actorName='" + actorName + '\'' +
                ", languageName='" + languageName + '\'';
    }
}
