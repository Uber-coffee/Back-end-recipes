package menu.controller.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import menu.entity.Class;
import menu.service.web.ClassService;
import menu.swagger.SwaggerMethodToDocument;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/w/classes")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@Api
public class ClassController {
    private ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping
    @SwaggerMethodToDocument
    @ApiOperation(value = "Update or create new class")
    public ResponseEntity<Class> addClass(@Validated @RequestBody Class category) {
        return new ResponseEntity<>(classService.addClass(category), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @SwaggerMethodToDocument
    @ApiOperation(value = "Get class by id")
    public ResponseEntity<Class> getClass(@PathVariable Long id) {
        return new ResponseEntity<>(classService.getClass(id), HttpStatus.OK);
    }

    @GetMapping
    @SwaggerMethodToDocument
    @ApiOperation(value = "Get set of all classes")
    public ResponseEntity<List<Class>> getClasses() {
        return new ResponseEntity<>(classService.getClasses(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @SwaggerMethodToDocument
    @ApiOperation(value = "Delete class with current id")
    public void deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
    }
}
