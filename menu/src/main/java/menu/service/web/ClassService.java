package menu.service.web;

import menu.entity.Class;
import menu.exception.InvalidIdException;
import menu.payload.web.ClassRequest;
import menu.repository.ClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {
    private ClassRepository classRepository;

    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public Class addClass(ClassRequest classRequest) {
        Class category = new Class();
        category.setId(classRequest.getId());
        category.setName(classRequest.getName());
        category.setIsRequired(classRequest.getIsRequired());
        category.setIsSingle(classRequest.getIsSingle());

        return classRepository.save(category);
    }

    public Class getClass(Long id) {
        if (id != null) {
            Optional<Class> category = classRepository.findById(id);
            if (category.isPresent()) {
                return category.get();
            }
        }

        throw new InvalidIdException("There is no class with such id");
    }

    public List<Class> getClasses() {
        return classRepository.findAll();
    }

    public void deleteClass(Long id) {
        classRepository.delete(getClass(id));
    }


}
