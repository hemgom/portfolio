package CloneCoding.NaverCafe.domain.keyword.service;

import CloneCoding.NaverCafe.domain.cafe.Cafe;

import java.util.List;

public interface KeywordService {

    void applyKeywords(List<String> keywords, Cafe cafe);

}
