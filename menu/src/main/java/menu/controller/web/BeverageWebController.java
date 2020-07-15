package menu.controller.web;

import menu.entity.Beverage;
import menu.payload.web.BeverageRequest;
import menu.service.web.BeverageWebService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import menu.swagger.SwaggerMethodToDocument;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/w/beverages")
@Api
public class BeverageWebController {
    private BeverageWebService beverageWebService;

    public BeverageWebController(BeverageWebService beverageWebService) {
        this.beverageWebService = beverageWebService;
    }

    @PostMapping
    @SwaggerMethodToDocument
    @ApiOperation(
            value = "Update or create new beverage",
            authorizations = @Authorization(value="jwtToken")
    )
    public ResponseEntity<Beverage> addBeverage(@RequestBody BeverageRequest beverageRequest) {
        return new ResponseEntity<>(beverageWebService.addBeverage(beverageRequest), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @SwaggerMethodToDocument
    @ApiOperation(
            value = "Get beverage with current id",
            authorizations = @Authorization(value="jwtToken")
    )
    public ResponseEntity<Beverage> getBeverage(@PathVariable Long id) {
        return new ResponseEntity<>(beverageWebService.getBeverage(id), HttpStatus.OK);
    }

    @GetMapping
    @SwaggerMethodToDocument
    @ApiOperation(
            value = "Get set of all beverages",
            authorizations = @Authorization(value="jwtToken")
    )
    public ResponseEntity<List<Beverage>> getBeverages() {
        return new ResponseEntity<>(beverageWebService.getBeverages(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @SwaggerMethodToDocument
    @ApiOperation(
            value = "Delete beverage with current id",
            authorizations = @Authorization(value="jwtToken")
    )
    public void deleteBeverage(@PathVariable Long id) {
        beverageWebService.deleteBeverage(id);
    }
}
