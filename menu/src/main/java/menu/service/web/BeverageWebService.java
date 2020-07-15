package menu.service.web;

import menu.entity.Beverage;
import menu.entity.Component;
import menu.entity.Recipe;
import menu.exception.InvalidIdException;
import menu.payload.web.BeverageRequest;
import menu.repository.BeverageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeverageWebService {
    private BeverageRepository beverageRepository;
    private ComponentService componentService;

    public BeverageWebService(BeverageRepository beverageRepository, ComponentService componentService) {
        this.beverageRepository = beverageRepository;
        this.componentService = componentService;
    }

    public Beverage addBeverage(BeverageRequest beverageRequest) {
        Beverage beverage = new Beverage();
        beverage.setId(beverageRequest.getId());
        beverage.setBeverageName(beverageRequest.getName());
        beverage.setPrice(beverageRequest.getPrice());
        beverageRequest.getRecipe().forEach(component -> {
            Component recipeComponent = componentService.getComponent(component.getComponentId());
            Recipe recipe = new Recipe();
            recipe.setComponent(recipeComponent);
            recipe.setQuantity(component.getQuantity());
            recipe.setBeverage(beverage);
            beverage.getRecipe().add(recipe);
        });

        if (beverage.getId() != null) {
            deleteBeverage(beverage.getId());
        }

        return beverageRepository.save(beverage);
    }

    public List<Beverage> getBeverages() {
        return beverageRepository.findAll();
    }

    public Beverage getBeverage(Long id) throws InvalidIdException {
        Optional<Beverage> beverage = beverageRepository.findById(id);
        if (beverage.isPresent()) {
            return beverage.get();
        }

        throw new InvalidIdException("There is no beverage with such id");
    }

    public void deleteBeverage(Long id) {
        beverageRepository.delete(getBeverage(id));
    }
}
