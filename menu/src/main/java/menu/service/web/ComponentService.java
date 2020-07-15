package menu.service.web;

import menu.entity.Component;
import menu.exception.InvalidIdException;
import menu.payload.web.ComponentRequest;
import menu.repository.ComponentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComponentService {
    private ComponentRepository componentRepository;
    private ClassService classService;

    public ComponentService(ComponentRepository componentRepository, ClassService classService) {
        this.componentRepository = componentRepository;
        this.classService = classService;
    }

    public Component addComponent(ComponentRequest componentRequest) {
        Component component = new Component();
        component.setId(componentRequest.getId());
        component.setCategory(classService.getClass(componentRequest.getCategoryId()));
        component.setMeasure(componentRequest.getMeasure());
        component.setName(componentRequest.getName());
        return componentRepository.save(component);
    }

    public List<Component> getComponents() {
        return componentRepository.findAll();
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
