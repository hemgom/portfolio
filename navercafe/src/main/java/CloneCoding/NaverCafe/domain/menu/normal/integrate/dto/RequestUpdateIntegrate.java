package CloneCoding.NaverCafe.domain.menu.normal.integrate.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateIntegrate {

    @NotNull
    private int sequence;

    @NotNull
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
