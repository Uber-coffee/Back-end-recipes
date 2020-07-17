package menu.controller.mobile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import menu.payload.mobile.BeverageResponse;
import menu.service.mobile.BeverageMobileService;
import menu.swagger.SwaggerMethodToDocument;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/m/beverages")
@PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
@Api
public class BeverageMobileController {
    private BeverageMobileService beverageMobileService;

    public BeverageMobileController(BeverageMobileService beverageMobileService) {
        this.beverageMobileService = beverageMobileService;
    }

    @GetMapping
    @SwaggerMethodToDocument
    @ApiOperation(
            value = "Get beverages",
            authorizations = @Authorization(value="jwtToken")
    )
    public ResponseEntity<List<BeverageResponse>> getBeverages() {
        return new ResponseEntity<>(beverageMobileService.getBeverages(), HttpStatus.OK);
    }
}
