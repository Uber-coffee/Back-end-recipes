package menu.payload.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@NoArgsConstructor
public class BeverageRequest {
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @Positive
    private Long price;

    @NotNull
    private List<@Valid RecipeRequest> recipe;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static public class RecipeRequest {
        @NotNull
        @Positive
        private Long componentId;

        @NotNull
        @Positive
        private Long quantity;
    }
}


