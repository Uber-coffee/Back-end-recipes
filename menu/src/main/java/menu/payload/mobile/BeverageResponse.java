package menu.payload.mobile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import menu.entity.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeverageResponse {
    private Long price;

    private String name;

    private Double volume;

    private List<ComponentResponse> recipe = new ArrayList<>();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ComponentResponse {
        private String name;

        private Component.Measure measure;

        private Long quantity;
    }
}
