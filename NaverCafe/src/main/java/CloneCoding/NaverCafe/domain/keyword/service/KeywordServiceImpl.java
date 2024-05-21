package CloneCoding.NaverCafe.domain.keyword.service;

import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.keyword.Keyword;
import CloneCoding.NaverCafe.domain.keyword.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KeywordServiceImpl implements KeywordService {

    private final KeywordRepository keywordRepository;

    @Override
    public void applyKeywords(List<String> keywords, Cafe cafe) {

        for (String keyword : keywords) {
            Keyword addKeyword = Keyword.addKeyword(keyword, cafe);
            keywordRepository.save(addKeyword);
        }

    }

}
