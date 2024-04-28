package CloneCoding.NaverCafe.config;

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

}
