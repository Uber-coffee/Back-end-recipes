package menu.service;

import menu.entity.Component;
import menu.exception.InvalidIdException;
import menu.repository.ComponentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComponentService {
    private ComponentRepository componentRepository;

    public ComponentService(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    public Component addComponent(Component component) {
        component.getMyClass().setComponent(component);
        return componentRepository.save(component);
    }

    public List<Component> getComponents() {
        return (List<Component>) componentRepository.findAll();
    }

    public Component getComponent(Long id) throws InvalidIdException {
        Optional<Component> component = componentRepository.findById(id);
        if (component.isPresent()) {
            return component.get();
        }
        throw new InvalidIdException("There is no component with such id");
    }

    public void deleteComponent(Long id) {
        componentRepository.delete(getComponent(id));
    }
}
