package menu.payload.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeverageRequest {
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Long price;

    @NotNull
    private List<RecipeRequest> recipe;

    @Data
    @NoArgsConstructor
    static public class RecipeRequest {
        @NotNull
        private Long componentId;

        @NotNull
        private Long quantity;
    }
}


