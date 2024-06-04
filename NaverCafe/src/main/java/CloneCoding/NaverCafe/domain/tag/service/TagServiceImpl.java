package CloneCoding.NaverCafe.domain.tag.service;

import CloneCoding.NaverCafe.domain.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public void createTags(List<String> tags, Long normalId) {

    }

}
