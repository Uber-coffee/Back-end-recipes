package menu.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import menu.entity.Component;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComponentRequest {

    private Long id;

    @NotNull
    private Long categoryId;

    @NotNull
    private String name;

    @NotNull
    private Component.Measure measure;
}
