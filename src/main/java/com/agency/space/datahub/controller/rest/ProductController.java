package com.agency.space.datahub.controller.rest;

import com.agency.space.datahub.controller.model.Coordinate;
import com.agency.space.datahub.controller.model.Product;
import com.agency.space.datahub.controller.service.CoordinateService;
import com.agency.space.datahub.controller.service.ProductService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private CoordinateService coordinateService;

    public ProductController(ProductService productService, CoordinateService coordinateService) {
        this.productService = productService;
        this.coordinateService = coordinateService;
    }

    @RequestMapping(value = {"id"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long productId) {
        if (productId == null) {
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }

        Product product = this.productService.getById(productId);

        if (product == null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid Product product) {
        HttpHeaders httpHeaders = new HttpHeaders();

        if (product == null) {
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }

        this.productService.save(product);
        return new ResponseEntity<Product>(product, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> updateProduct(@RequestBody @Valid Product product) {
        HttpHeaders httpHeaders  = new HttpHeaders();

            if (product == null){
                return  new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
            }

        this.productService.save(product);
        return new ResponseEntity<Product>(product, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = {"id"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {
        Product product = this.productService.getById(id);

        if (product == null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

        this.productService.delete(id);
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products =  this.productService.getAll();

        if (products == null) {
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

}
