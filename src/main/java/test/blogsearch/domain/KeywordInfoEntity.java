package test.blogsearch.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class KeywordInfoEntity {
    @Id
    @Column(nullable = false)
    private String keyword;

    @Column(nullable = false)
    private Long searchCount;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(Long searchCount) {
        this.searchCount = searchCount;
    }

    public KeywordInfoEntity() {
        this.searchCount = 1L;
    }
}