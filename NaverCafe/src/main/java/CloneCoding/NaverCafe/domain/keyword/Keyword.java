package CloneCoding.NaverCafe.domain.keyword;

import CloneCoding.NaverCafe.domain.cafe.Cafe;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "KEYWORD")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Keyword {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "KEYWORD")
    private String keyword;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAFE_ID")
    private Cafe cafeId;

    public static Keyword addKeyword(String keyword, Cafe cafe) {
        return Keyword.builder()
                .keyword(keyword)
                .cafeId(cafe)
                .build();
    }

}
