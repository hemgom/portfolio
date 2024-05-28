package CloneCoding.NaverCafe.domain.bulletinBoard.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateGeneralBulletinBoard {

    @NotNull
    private int sequence;

    @NotBlank(message = "메뉴명을 입력해주세요")
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String writeAuth;

    @NotNull
    private String readAuth;

    @NotNull
    private String commentAuth;

    @NotNull
    private boolean useFavorite;

}
