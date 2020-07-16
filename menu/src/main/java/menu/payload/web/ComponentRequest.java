package menu.payload.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import menu.entity.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComponentRequest {

    private Long id;

    @NotNull
    @Positive
    private Long categoryId;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private Component.Measure measure;
}
