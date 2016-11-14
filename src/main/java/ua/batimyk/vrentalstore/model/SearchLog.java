package ua.batimyk.vrentalstore.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by N on 14-Nov-16.
 * video-rental-store-AWS
 */
@Entity
@Table(name = "search_log")
public class SearchLog {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "insert_date", insertable = false)
    private Timestamp insertDate;

    @Column(name = "search_criteria")
    private String searchCriteria;

    @Column(name = "result_count")
    private Integer resultCount;

    public SearchLog() {
    }

    public SearchLog(String userId, String searchCriteria, Integer resultCount) {
        this.userId = userId;
        this.searchCriteria = searchCriteria;
        this.resultCount = resultCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Timestamp getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Timestamp insertDate) {
        this.insertDate = insertDate;
    }

    public String getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public Integer getResultCount() {
        return resultCount;
    }

    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }
}
