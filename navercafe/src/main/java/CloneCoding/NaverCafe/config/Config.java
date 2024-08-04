package CloneCoding.NaverCafe.config;

import CloneCoding.NaverCafe.security.AesUtil;
import CloneCoding.NaverCafe.security.PasswordKey;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public JPAQueryFactory jpaQueryFactory (EntityManager em) {
        return new JPAQueryFactory(em);
    }

    @Bean
    public AesUtil aesUtil (PasswordKey passwordKey) {
        return new AesUtil(passwordKey.getPasswordKey());
    }

}
