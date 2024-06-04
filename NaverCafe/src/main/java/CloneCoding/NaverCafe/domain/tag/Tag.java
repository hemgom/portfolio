package CloneCoding.NaverCafe.domain.tag;

import CloneCoding.NaverCafe.domain.article.normal.Normal;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TAG")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Tag {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TAG_NAME")
    private String tagName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NORMAL_ID")
    private Normal normalId;

    public static List<Tag> createTags(List<String> tags, Normal normal) {
        List<Tag> result = new ArrayList<>();

        for (String t : tags) {
            Tag tag = create(t, normal);
            result.add(tag);
        }

        return result;
    }

    public static Tag create(String tagName, Normal normal) {
        return Tag.builder()
                .tagName(tagName)
                .normalId(normal)
                .build();
    }

}
