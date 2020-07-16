package menu.payload.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassRequest {
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private Boolean isSingle;

    @NotNull
    private Boolean isRequired;
}
