package CloneCoding.NaverCafe.security;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class PasswordKey {
    // 암호키 : 32비트
    public final String passwordKey = "AES_PRIVATE_KEY_THIS_TEST_32BYTE";
}
