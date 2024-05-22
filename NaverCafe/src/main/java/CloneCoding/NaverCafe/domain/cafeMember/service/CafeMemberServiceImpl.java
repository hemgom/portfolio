package CloneCoding.NaverCafe.domain.cafeMember.service;

import CloneCoding.NaverCafe.domain.cafeMember.repository.CafeMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeMemberServiceImpl implements CafeMemberService {

    private final CafeMemberRepository cafeMemberRepository;

}
