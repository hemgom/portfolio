package CloneCoding.NaverCafe.domain.cafe.service;

import CloneCoding.NaverCafe.domain.cafe.Cafe;
import CloneCoding.NaverCafe.domain.cafe.dto.RequestCreateCafe;
import CloneCoding.NaverCafe.domain.cafe.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeServiceImpl implements CafeService {

    private final CafeRepository cafeRepository;

    @Override
    public Cafe createCafe(RequestCreateCafe.CafeInfo request) {

        Cafe cafe = Cafe.createCafe(request);

        return cafeRepository.save(cafe);

    }

}
