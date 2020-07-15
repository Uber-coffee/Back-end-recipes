package menu.controller.web;

import menu.entity.Component;
import menu.payload.web.ComponentRequest;
import menu.service.web.ComponentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import menu.swagger.SwaggerMethodToDocument;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/w/components")
@Api
public class ComponentController {
    ComponentService componentService;

    public ComponentController(ComponentService componentService) {
        this.componentService = componentService;
    }

    @PostMapping
    @SwaggerMethodToDocument
    @ApiOperation(
            value = "Update or create new component",
            authorizations = @Authorization(value="jwtToken")
    )
    public ResponseEntity<Component> addComponent(@RequestBody ComponentRequest componentRequest) {
        return new ResponseEntity<>(componentService.addComponent(componentRequest), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @SwaggerMethodToDocument
    @ApiOperation(
            value = "Get component with current id",
            authorizations = @Authorization(value="jwtToken")
    )
    public ResponseEntity<Component> getComponent(@PathVariable Long id) {
        return new ResponseEntity<>(componentService.getComponent(id), HttpStatus.OK);
    }

    @GetMapping
    @SwaggerMethodToDocument
    @ApiOperation(
            value = "Get set of all components",
            authorizations = @Authorization(value="jwtToken")
    )
    public ResponseEntity<List<Component>> getComponents() {
        return new ResponseEntity<>(componentService.getComponents(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @SwaggerMethodToDocument
    @ApiOperation(
            value = "Delete beverage with current id",
            authorizations = @Authorization(value="jwtToken")
    )
    public void deleteComponent(@PathVariable Long id) {
        componentService.deleteComponent(id);
    }
}
