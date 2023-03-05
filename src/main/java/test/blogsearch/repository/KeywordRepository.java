package test.blogsearch.repository;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import test.blogsearch.domain.KeywordInfoEntity;

import java.util.List;

public interface KeywordRepository extends JpaRepository<KeywordInfoEntity, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT k from KeywordInfoEntity k where k.keyword = :keyword")
    KeywordInfoEntity findKeywordAndUpdate(@Param("keyword") String keyword);

    List<KeywordInfoEntity> findTop10ByOrderBySearchCountDesc();
}
