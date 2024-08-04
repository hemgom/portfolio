package CloneCoding.NaverCafe.domain.tag.service;

import java.util.List;

public interface TagService {

    void createTags(List<String> tags, Long normalId);

}
