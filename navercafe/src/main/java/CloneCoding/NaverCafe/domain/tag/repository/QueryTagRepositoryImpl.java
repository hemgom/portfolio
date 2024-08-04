package CloneCoding.NaverCafe.domain.tag.repository;

import CloneCoding.NaverCafe.domain.article.normal.Normal;
import CloneCoding.NaverCafe.domain.tag.Tag;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.Optional;

import static CloneCoding.NaverCafe.domain.tag.QTag.tag;

@Repository
@RequiredArgsConstructor
public class QueryTagRepositoryImpl implements QueryTagRepository {

    private final JPAQueryFactory query;

    @Override
    public Tag findByNameAndArticle(String tagName, Normal normal) {
        return Optional.ofNullable(query
                        .selectFrom(tag)
                        .where(tag.tagName.eq(tagName), tag.normalId.eq(normal))
                        .fetchOne())
                .orElseThrow(() -> new NoSuchElementException("태그 정보를 찾을 수 없습니다."));
    }

}
