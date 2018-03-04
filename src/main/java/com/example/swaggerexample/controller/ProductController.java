package com.example.swaggerexample.controller;

import com.example.swaggerexample.model.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
@Api(value="myProductController", description="Operations pertaining to products in Swagger example")
public class ProductController {

    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json") // produces effect on `Response Content Type` on swagger-ui.html
    @ApiOperation(value = "View a list of available products")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public List<Product> list() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1l, "phone"));
        products.add(new Product(2l, "tv"));

        return products;
    }

    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET)
    public Product showProduct(@PathVariable Integer id) {
        System.out.println("Show product id: " + id);

        return new Product(3l, "computer");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity saveProduct(@RequestBody Product product) {
        System.out.println("Saving product: " + product);

        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        System.out.println("Update id: " + id + ", product: " + product);

        return new ResponseEntity("Product updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Integer id) {
        System.out.println("Delete product id: " + id);

        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
    }
}
