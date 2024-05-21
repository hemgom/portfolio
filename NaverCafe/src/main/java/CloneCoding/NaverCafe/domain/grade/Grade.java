package CloneCoding.NaverCafe.domain.grade;

import CloneCoding.NaverCafe.domain.cafe.Cafe;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "GRADE")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "RANK")
    private int rank;

    @Column(name = "GRADE_NAME")
    private String gradeName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "RANK_UP_SETTING")
    private String rankUpSetting;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAFE_ID")
    private Cafe cafeId;

}
