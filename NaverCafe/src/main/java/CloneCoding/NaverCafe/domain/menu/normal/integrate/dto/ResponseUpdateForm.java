package CloneCoding.NaverCafe.domain.menu.normal.integrate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUpdateForm {

    private int sequence;

    private String name;

    private String description;

    private String writeAuth;

    private String readAuth;

    private String commentAuth;

    private boolean useFavorite;

}
