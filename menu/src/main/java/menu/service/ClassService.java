package menu.service;

import menu.entity.Class;
import menu.exception.InvalidIdException;
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

    public Class addClass(Class category) {
        return classRepository.save(category);
    }

    public Class getClass(Long id) {
        Optional<Class> category = classRepository.findById(id);
        if (category.isPresent()) {
            return category.get();
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
