package CloneCoding.NaverCafe.domain.tag.repository;

import CloneCoding.NaverCafe.domain.article.normal.Normal;
import CloneCoding.NaverCafe.domain.tag.Tag;

public interface QueryTagRepository {

    Tag findByNameAndArticle(String tagName, Normal normal);

}
