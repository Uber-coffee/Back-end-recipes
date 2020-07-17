package menu.service.mobile;

import menu.entity.Beverage;
import menu.entity.Component;
import menu.payload.mobile.BeverageResponse;
import menu.repository.BeverageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BeverageMobileService {
    private BeverageRepository beverageRepository;

    public BeverageMobileService(BeverageRepository beverageRepository) {
        this.beverageRepository = beverageRepository;
    }

    public List<BeverageResponse> getBeverages() {
        List<Beverage> beverages = beverageRepository.findAll();
        return beverages
                .stream()
                .map(beverage -> {
                    Optional<Double> optionalVolume = beverage.getRecipe()
                            .stream()
                            .filter(component ->
                                    component.getComponent()
                                            .getName()
                                            .toUpperCase()
                                            .startsWith("CUP")
                            )
                            .map(recipeComponent ->
                                    Double.parseDouble(
                                            recipeComponent
                                                    .getComponent()
                                                    .getName()
                                                    .substring(4)
                                    )
                            )
                            .findFirst();

                    List<BeverageResponse.ComponentResponse> componentResponses =
                            beverage
                                    .getRecipe()
                                    .stream()
                                    .map(recipeComponent -> {
                                        Component component = recipeComponent.getComponent();
                                        return new BeverageResponse.ComponentResponse(
                                                component.getName(),
                                                component.getMeasure(),
                                                recipeComponent.getQuantity()
                                        );
                                    })
                                    .collect(Collectors.toList());

                    Double volume = 0.0;
                    if (optionalVolume.isPresent()) {
                        volume = optionalVolume.get();
                    }

                    return new BeverageResponse(
                            beverage.getPrice(),
                            beverage.getBeverageName(),
                            volume,
                            componentResponses
                    );
                })
                .collect(Collectors.toList());
    }
}
